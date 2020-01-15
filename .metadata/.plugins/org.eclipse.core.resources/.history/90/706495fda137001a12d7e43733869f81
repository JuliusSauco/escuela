package com.example.demo.imp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Personas;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;	
import com.example.demo.excepciones.PersonaNotFoundExecption;

@Transactional(readOnly = true)
@Service
public class PersonaServiceimpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Personas> obtenerPersonas() {
		// TODO Auto-generated method stub
		
		return StreamSupport.stream(personaRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Transactional(readOnly = false)
	@Override
	public Personas guardarPersonas(Personas personas) {
		// TODO Auto-generated method stub
		//if(personaRepository.findByDni(personas.getDni()))
		Personas nuevo = personaRepository.save(personas);
		personaRepository.refresh(nuevo);
		return nuevo;
	}

	@Override
	public Personas obtenerPersonaId(Long id) throws PersonaNotFoundExecption {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).orElseThrow(
				() -> new PersonaNotFoundExecption(String.format("No se encontro el id", id)));
	}
	
}
