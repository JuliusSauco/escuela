package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Producto;

@Service
public interface ProductoService {
	
	public Iterable<Producto> obtenerProductos();
	//public Producto guardarProducto(ProductoReducidoDTO productoReducidoDTO);
	public Producto obtenerProductoPorID(Long id);
	public Producto guardarProducto(Producto producto);
	
}
