package com.example.demo.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.entity.Persona;
import com.example.demo.util.CustomRepository;

@Repository
public interface PersonaRepository extends CustomRepository<Persona, Long> {
	
	Optional<PersonaDTO> findByDni(String dni);
	
}

