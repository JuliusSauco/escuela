package com.example.demo.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
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
import com.example.demo.dto.OrdenDTO;
import com.example.demo.dto.OrdenReducidoDTO;
import com.example.demo.dto.PrecioDTO;
import com.example.demo.entity.DetalleOrden;
import com.example.demo.entity.Orden;
import com.example.demo.excepciones.ResourceNotFoundExecption;
import com.example.demo.excepciones.ValidacionException;
import com.example.demo.service.DetalleOrdenService;
import com.example.demo.service.OrdenService;

@RestController
@RefreshScope
public class OrdenController {

	@Autowired
	private DetalleOrdenService detalleOrdenService;
	
	@Autowired
	private OrdenService ordenService;
	
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

	//PODRÍA APLICAR ESTE METODO SI ORDEN NO DEPENDIERA DE ORDEN DETALLE
	@PostMapping("/guardar_orden")
	public OrdenDTO guardarOrden(@Valid @RequestBody OrdenReducidoDTO ordenRDTO) {
		
		//EN CASO DE QUE ORDEN SEA INDEPENDIENTE DE DETALLE LO USARIA.		
		Date date = new Date();		ModelMapper mapper = new ModelMapper();
		Orden orden = mapper.map(ordenRDTO, Orden.class);
		orden.setFechaEnvio(date);
		return mapper.map(ordenService.guardarOrden(orden), OrdenDTO.class);
		
	}
	
	//ESTE SI USO
	@PostMapping("/nuevaorden")
	public OrdenDTO generarNuevaOrden(@Valid @RequestBody OrdenDTO ordenDTO) throws ResourceNotFoundExecption, ValidacionException {
		
		ModelMapper mapper = new ModelMapper();
		Orden orden = new Orden();
		//DECLARO EL CONTADOR, CONTARÉ CUANTOS DETALLES HAY
		int i = 0;
		//VARIABLE TEMPORAL PARA ALMACENAR EL TOTAL
		BigDecimal total = null;
		//CREO EL OBJETO REDUCIDO PARA LUEGO SETEAR LOS DETALLES DESDE ordenDTO
		DetalleOrdenReducidoDTO detalleOrdenRDTO = new DetalleOrdenReducidoDTO();
		
		//ITERAMOS TODO EL PROCESO PARA PODER INSERTAR TODOS LOS DETALLES DE ORDEN
		while(i <= ordenDTO.getDetalleOrdenes().size()) {
			
			PrecioDTO precio = getPrecio("producto-ms", detalleOrdenRDTO.getIdProducto());
			detalleOrdenRDTO.setPrecio(precio.getPrecio());
	
			CantidadDTO cantidadDTO = getCantidad("almacen-ms", detalleOrdenRDTO.getIdProducto());
			
			if(cantidadDTO.getCantidadStock() < detalleOrdenRDTO.getCantidad()) {			
				throw new ValidacionException("La cantidad sobrepasa el stock disponible");
			}
			DetalleOrden detalleOrden = mapper.map(detalleOrdenRDTO, DetalleOrden.class);

			//POR ULTIMO GUARDO LOS DETALLE ORDEN GENERADOS
			DetalleOrdenDTO detalleOrdenDTO = new DetalleOrdenDTO();
			
			//LO UNICO QUE FALTARIA ES ACTUALIZAR EL ID DE ORDEN EN EL DETALLE
			//			detalleOrdenDTO.setOrden();
			
			detalleOrdenDTO =  mapper.map(detalleOrdenService.guardarDetalleOrden(detalleOrden), DetalleOrdenDTO.class);
			//ACUMULO LA SUMA DE DETALLE ORDEN DEL RDTO
			total = total.add(detalleOrden.getPrecio());
			//AUMENTO MI CONTADOR PARA QUE ESTE MAS CERCA DEL TOTAL DE DETALLES ORDEN
			i = i + 1;
			
		}
		
		//SETEO LA FECHA ACUTAL
		Date date = new Date();
		orden = mapper.map(ordenDTO, Orden.class);
		orden.setFecha(date);
		//SETEO EL TOTAL DE LA ORDEN DE VENTA
		orden.setTotal(total);
		
		return mapper.map(ordenService.guardarOrden(orden), OrdenDTO.class);

	}
	
}
