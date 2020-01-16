package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.excepciones.ResourceNotFoundExecption;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public Integer obtenerCantidadProductos(Long idProducto) throws ResourceNotFoundExecption {
		return stockRepository.obtCantidadTotal(idProducto).orElseThrow(
				() -> new ResourceNotFoundExecption("No se encontro la persona con el codigo: " + idProducto));
	}

	@Override
	public Integer obtenerCatidadProductosPorTienda(Long idProducto, Long idTienda) throws ResourceNotFoundExecption {
		// TODO Auto-generated method stub
		return stockRepository.obtCantidad(idProducto, idTienda).orElseThrow(
				() -> new ResourceNotFoundExecption("No se encontro el producto con el codigo: " + idProducto));
	}
	
}
