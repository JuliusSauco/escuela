package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Stock;
import com.example.demo.util.CustomRepository;

@Repository
public interface StockRepository extends CustomRepository<Stock, Long>  {
	
	
	@Query("SELECT SUM(s.cantidad) FROM stock s WHERE s.id_producto = ?1")
	Optional<Integer> obtCantidadTotal(Long idProducto);
	
	@Query("SELECT SUM(s.cantidad) FROM stock s WHERE s.id_producto = ?1 AND s.id_tienda = ?2")
	Optional<Integer> obtCantidad(Long idProducto, Long idTienda);
	
}
