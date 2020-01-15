package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.entity.Personas;
import com.example.demo.excepciones.PersonaNotFoundExecption;
import com.example.demo.service.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@RequestMapping("/personas")
	public List<Personas> getPersonas() {
		return personaService.obtenerPersonas();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/personas")
	public PersonaDTO guardarPersonas(@Valid @RequestBody Personas personas) {
		//return personaService.guardarPersonas(personas);
		ModelMapper mapper = new ModelMapper();
		Personas nuevo = personaService.guardarPersonas(mapper.map(personas, Personas.class));
		return mapper.map(nuevo, PersonaDTO.class);
	}
	
	@GetMapping("/personas/{id}")
	public Personas obtenerPorId(@PathVariable("id") Long id) throws PersonaNotFoundExecption {
		return personaService.obtenerPersonaId(id);
	}
}
