package com.example.demo.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.excepciones.ErrorDetail;
import com.example.demo.excepciones.PersonaNotFoundExecption;

@ControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler (PersonaNotFoundExecption.class)
	public ResponseEntity<?> personaNotFoundExecption(PersonaNotFoundExecption ex, WebRequest request){
		ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}

}
