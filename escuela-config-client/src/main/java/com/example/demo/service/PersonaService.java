package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Persona;
import com.example.demo.excepciones.ResourceNotFoundExecption;

public interface PersonaService {
	public List<Persona> obtenerPersonas();

	public Persona guardarPersonas(Persona persona) throws Exception;
	
	public Persona obtenerPersonaId(Long id) throws ResourceNotFoundExecption;

	public Persona asociarCompany(Long id_company, Long id);

}
