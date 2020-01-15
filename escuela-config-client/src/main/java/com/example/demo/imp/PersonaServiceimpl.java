package com.example.demo.imp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Company;
import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;	
import com.example.demo.excepciones.ResourceNotFoundExecption;

@Transactional(readOnly = true)
@Service
public class PersonaServiceimpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> obtenerPersonas() {
		// TODO Auto-generated method stub
		
		return StreamSupport.stream(personaRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Transactional(readOnly = false)
	@Override
	public Persona guardarPersonas(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		if(personaRepository.findByDni(persona.getDni()).isPresent()) {
			throw new Exception("Ya existe una persona con ese DNI");
		}
		Persona nuevo = personaRepository.save(persona);
		personaRepository.refresh(nuevo);
		return nuevo;
	}

	@Override
	public Persona obtenerPersonaId(Long id) throws ResourceNotFoundExecption {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExecption(String.format("No se encontro el id", id)));
	}
	
	@Override
	public Persona asociarCompany(Long id_company, Long id) {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setId(id);
		Company company = new Company();
		company.setId_compania(id_company);
		persona.setCompany(company);
		return personaRepository.save(persona);
	}
	
}
