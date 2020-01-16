package com.example.demo.service;


import com.example.demo.excepciones.ResourceNotFoundExecption;

public interface StockService {

	public Integer obtenerCantidadProductos(Long idProducto) throws ResourceNotFoundExecption;

	public Integer obtenerCatidadProductosPorTienda(Long idProducto, Long idTienda) throws ResourceNotFoundExecption;

}
