package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.CantidadDTO;
import com.example.demo.excepciones.ResourceNotFoundExecption;
import com.example.demo.service.StockService;

@RestController
@RefreshScope
public class StockController {

	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/stock/acumulado/producto/{idProducto}")
	public CantidadDTO obtenerCantidadTienda(@PathVariable("idProducto") Long idProducto) throws ResourceNotFoundExecption {
		CantidadDTO response = new CantidadDTO();
		response.setCantidadStock(stockService.obtenerCantidadProductos(idProducto));
		return response;
	}
	
	@GetMapping("/stock/producto/{idProducto}/tienda/{idTienda}")
	public CantidadDTO obtenerCantidadProductosPorTienda(@PathVariable("idProducto") Long idProducto, 
			@PathVariable("idTienda") Long idTienda) throws ResourceNotFoundExecption{
		CantidadDTO response = new CantidadDTO();
		response.setCantidadStock(stockService.obtenerCatidadProductosPorTienda(idProducto, idTienda));
		//response.setCantidadStock(666);
		return response;
	}
	
}
