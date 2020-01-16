package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.TipoProducto;
import com.example.demo.util.CustomRepository;

@Repository
public interface TipoProductoRepository extends CustomRepository<TipoProducto, Long> {

}
