package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.DetalleOrden;
import com.example.demo.util.CustomRepository;

@Repository
public interface DetalleOrdenRepository extends CustomRepository<DetalleOrden, Long> {
	
}
