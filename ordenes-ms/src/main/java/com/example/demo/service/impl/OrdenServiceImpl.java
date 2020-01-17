package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Orden;
import com.example.demo.repository.OrdenRepository;
import com.example.demo.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService{
	
	@Autowired
	private OrdenRepository ordenRepository;
	
	@Override
	public Orden guardarOrden(Orden orden) {
		// TODO Auto-generated method stub
		return ordenRepository.save(orden);
	}
		

}
