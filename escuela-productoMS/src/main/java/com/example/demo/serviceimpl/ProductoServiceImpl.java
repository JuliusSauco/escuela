package com.example.demo.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Producto;
import com.example.demo.excepciones.ResourceNotFoundExecption;
import com.example.demo.repository.ImagenProductoRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.TipoProductoRepository;
import com.example.demo.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	
	@Autowired
	private ImagenProductoRepository imagenProductoRepository;
	
	@Override
	public Iterable<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto obtenerProductoPorID(Long id) throws ResourceNotFoundExecption {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExecption(String.format("No se encontro el id: ", id)));
	}

	@Override
	public Producto guardarProducto(Producto producto) throws ResourceNotFoundExecption {
		// TODO Auto-generated method stub
		tipoProductoRepository.findById(producto.getTipoProducto().getIdTipoProducto()).orElseThrow(
				() -> new ResourceNotFoundExecption(String.format("No se encontro el tipo de producto: " + producto.getTipoProducto().getIdTipoProducto())));
		imagenProductoRepository.findById(producto.getImagenProducto().getIdImagenProducto()).orElseThrow(
				() -> new ResourceNotFoundExecption(String.format("No se encontró la imagen: " + producto.getImagenProducto().getIdImagenProducto())));
		return productoRepository.save(producto);
	}

	@Override
	public Producto obtenerPrecioProducto(Long id_producto) throws ResourceNotFoundExecption {
		// TODO Auto-generated method stub
		Producto producto = productoRepository.findById(id_producto).orElseThrow(
				() -> new ResourceNotFoundExecption(String.format("No se encontro el id: ", id_producto)));
		
		return producto;
	}

}
