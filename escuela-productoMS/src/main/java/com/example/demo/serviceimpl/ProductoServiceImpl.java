package com.example.demo.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Iterable<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
		//return StreamSupport.stream(productoRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Producto obtenerProductoPorID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

}
