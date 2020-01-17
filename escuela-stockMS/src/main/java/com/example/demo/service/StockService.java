package com.example.demo.service;

import com.example.demo.excepciones.ResourceNotFoundExecption;

public interface StockService {

	public int obtenerCantidadProductos(Long idProducto) throws ResourceNotFoundExecption;

	public int obtenerCatidadProductosPorTienda(Long idProducto, Long idTienda) throws ResourceNotFoundExecption;

}
