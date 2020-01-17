package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DetalleOrden;
import com.example.demo.repository.DetalleOrdenRepository;
import com.example.demo.repository.OrdenRepository;
import com.example.demo.service.DetalleOrdenService;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{
	
	@Autowired
	private OrdenRepository ordenRepository;
	
	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;

	@Override
	public DetalleOrden guardarDetalleOrden(DetalleOrden detalleOrden) {
		// TODO Auto-generated method stub
		return null;
	}

}
