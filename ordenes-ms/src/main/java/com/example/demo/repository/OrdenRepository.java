package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Orden;
import com.example.demo.util.CustomRepository;

@Repository
public interface OrdenRepository extends CustomRepository<Orden, Long>{

}
