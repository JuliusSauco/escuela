package com.example.demo.imp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Personas;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;

@Service
public class PersonaServiceimpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Personas> obtenerPersonas() {
		// TODO Auto-generated method stub
		
		return StreamSupport.stream(personaRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public void guardarPersonas(Personas personas) {
		// TODO Auto-generated method stub
		
	}

}
