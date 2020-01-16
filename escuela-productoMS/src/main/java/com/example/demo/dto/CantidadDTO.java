package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CantidadDTO {

	@JsonProperty(value = "cantidad")
	private Long cantidadStock;

}
