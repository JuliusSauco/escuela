package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {

	//@JsonProperty(value = "nombre")
	private String nombres;
	private String apellidos;
	private String dni;
	private CompanyReducidoDTO companyDTO;
}
