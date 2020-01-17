package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Stock;
import com.example.demo.util.CustomRepository;

@Repository
public interface StockRepository extends CustomRepository<Stock, Long>  {
	
	@Query(value="select sum(s.cantidad) from stock s where s.id_producto = ?1", nativeQuery = true)
	Optional<Integer> obtCantidadTotal(Long idProducto);
	
	@Query(value="select sum(s.cantidad) from stock s where s.id_producto = ?1 and s.id_tienda = ?2", nativeQuery = true)
	Optional<Integer> obtCantidad(Long idProducto, Long idTienda);
	
}
