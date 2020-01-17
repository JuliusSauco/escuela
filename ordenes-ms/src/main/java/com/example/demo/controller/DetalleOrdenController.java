package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.dto.CantidadDTO;
import com.example.demo.dto.DetalleOrdenDTO;
import com.example.demo.dto.DetalleOrdenReducidoDTO;
import com.example.demo.dto.PrecioDTO;
import com.example.demo.entity.DetalleOrden;
import com.example.demo.excepciones.ResourceNotFoundExecption;
import com.example.demo.excepciones.ValidacionException;
import com.example.demo.service.DetalleOrdenService;

@RestController
@RefreshScope
public class DetalleOrdenController {
	
	@Autowired
	private DetalleOrdenService detalleOrdenService;
	
	@Autowired
	private DiscoveryClient client;
	
	//OBTENGO EL PRECIO DE UN PRODUCTO, ESTE METODO LO HE CREADO EN PRODUCTOS
	public PrecioDTO getPrecio(String service, Long idProducto) throws ResourceNotFoundExecption {
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && list.size() > 0) {
			int rand = (int) Math.round(Math.random()*10) % list.size();
			URI uri = list.get(rand).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri.toString() + "producto_precio/{idProducto}",
						PrecioDTO.class, idProducto);
			}
			throw new ResourceNotFoundExecption("No se encontro el producto: " + idProducto);
		}
		return null;
	}
	
	//OBTENGO LA CANTIDAD DE PRODUCTOS EN STOCK
	public CantidadDTO getCantidad(String service, Long idProducto) throws ResourceNotFoundExecption {
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && list.size() > 0) {
			int rand = (int) Math.round(Math.random()*10) % list.size();
			URI uri = list.get(rand).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri.toString() + "/stock/acumulado/{idProducto}",
						CantidadDTO.class, idProducto);
			}
			throw new ResourceNotFoundExecption("No se encontro el producto: " + idProducto);
		}
		return null;
	}
	
	//UNA POSIBLE INSERCIÍON EN CASO DE QUE ORDEN SEA INDEPENDIENTE DE DETALLEORDEN, PERO COMO NOS PIDE EL TOTAL, ESTO NO OCURRE
	@PostMapping("/detalleOrden")
	public DetalleOrdenDTO guardarOrden(@RequestBody DetalleOrdenReducidoDTO detalleOrdenRDTO) throws ValidacionException, ResourceNotFoundExecption {

		ModelMapper mapper = new ModelMapper();
		PrecioDTO precio = getPrecio("producto-ms", detalleOrdenRDTO.getIdProducto());
		detalleOrdenRDTO.setPrecio(precio.getPrecio());
		
		CantidadDTO cantidadDTO = getCantidad("almacen-ms", detalleOrdenRDTO.getIdProducto());
		
		if(cantidadDTO.getCantidadStock() < detalleOrdenRDTO.getCantidad()) {			
			throw new ValidacionException("La cantidad sobrepasa el stock disponible");
		}
		DetalleOrden detalleOrden = mapper.map(detalleOrdenRDTO, DetalleOrden.class);
		
		return mapper.map(detalleOrdenService.guardarDetalleOrden(detalleOrden), DetalleOrdenDTO.class);
		
	}
}
