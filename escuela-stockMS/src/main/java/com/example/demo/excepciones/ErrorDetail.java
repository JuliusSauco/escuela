package com.example.demo.excepciones;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetail {

	private Date fecha;
	private String mensaje;
	private String details;
}
