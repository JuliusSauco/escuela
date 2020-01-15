package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Personas;
import com.example.demo.service.PersonaService;

@RestController
public class EscuelaControlador {
	
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping("/personas")
	public List<Personas> getPersonas() {
		return personaService.obtenerPersonas();
	}
	
//	@Value("${palabra}")
//	String palabra;
//	
//	@RequestMapping("/palabra")
//	public String obtenerPalabra() {
//		return "La palabra es: " + palabra;
//	}
}
