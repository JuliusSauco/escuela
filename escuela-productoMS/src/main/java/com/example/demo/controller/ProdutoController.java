package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CantidadDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.ProductoReducidoDTO;
import com.example.demo.entity.ImagenProducto;
import com.example.demo.entity.Producto;
import com.example.demo.entity.TipoProducto;
import com.example.demo.excepciones.ResourceNotFoundExecption;
import com.example.demo.excepciones.ValidationException;
import com.example.demo.service.ProductoService;

@RestController
@RefreshScope
public class ProdutoController {
	
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private ProductoService productoService;
	
	public CantidadDTO getCantidad(String service, Long idProducto) {
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && list.size() > 0) {
			int rand = (int) Math.round(Math.random()*10) % list.size();
			URI uri = list.get(rand).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri.toString() + "/stock/acumulado/producto/{idProducto}",
						CantidadDTO.class, idProducto);
			}
		}
		return null;
	}
	
	@Value("${igv}")
	private String igv;
	
	@GetMapping("/igv")
	public String getIgv() {
		return "El igv actual es: " + this.igv;
	}
	
	@GetMapping("/productos")
	public Iterable<ProductoDTO> obtenerProductos(){
		ModelMapper modelMapper = new ModelMapper();
		Iterable<Producto> productos = productoService.obtenerProductos();
		return StreamSupport.stream(productos.spliterator(), false)
				.map(c -> modelMapper.map(c, ProductoDTO.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/productos/{id_producto}")
	public ProductoDTO obtenerProductoById(@PathVariable("id_producto") Long id_producto) throws ResourceNotFoundExecption{
		ModelMapper mapper = new ModelMapper();
		ProductoDTO producto = mapper.map(productoService.obtenerProductoPorID(id_producto), ProductoDTO.class);
		CantidadDTO cantidadDTO = getCantidad("escuela-stockMS", id_producto);
		producto.setCantidadStock(cantidadDTO.getCantidadStock());
		return producto;
	}
	
	@PostMapping("/productos")
	public ProductoDTO guardarProducto(@Valid @RequestBody ProductoReducidoDTO productoRDTO) throws ValidationException, ResourceNotFoundExecption{
		ModelMapper modelMapper = new ModelMapper();
		Producto producto = modelMapper.map(productoRDTO, Producto.class);
		
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setCodigo(productoRDTO.getCodigoProducto());
		
		ImagenProducto imagenProducto = new ImagenProducto();
		imagenProducto.setRutaImagen(productoRDTO.getRutaImagen());
		imagenProducto.setRutaThumbnail(productoRDTO.getRutaThumbnail());
		
		producto.setTipoProducto(tipoProducto);
		producto.setImagenProducto(imagenProducto);
		
		return modelMapper.map(productoService.guardarProducto(producto), ProductoDTO.class);
	}
	
}
