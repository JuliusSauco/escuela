package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Producto;
import com.example.demo.excepciones.ResourceNotFoundExecption;

@Service
public interface ProductoService {
	
	public Iterable<Producto> obtenerProductos();

	public Producto obtenerProductoPorID(Long id) throws ResourceNotFoundExecption;
	public Producto guardarProducto(Producto producto) throws ResourceNotFoundExecption;
	public Producto obtenerPrecioProducto(Long id_producto) throws ResourceNotFoundExecption;
	
}
