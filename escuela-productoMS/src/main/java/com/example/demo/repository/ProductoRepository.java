package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Producto;
import com.example.demo.util.CustomRepository;

@Repository
public interface ProductoRepository extends CustomRepository<Producto, Long> {

}