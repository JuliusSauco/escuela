package com.example.demo.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.excepciones.ErrorDetail;
import com.example.demo.excepciones.ResourceNotFoundExecption;
import com.example.demo.excepciones.ValidationException;


@ControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler (ResourceNotFoundExecption.class)
	public ResponseEntity<?> resourceNotFoundExecption(ResourceNotFoundExecption ex, WebRequest request){
		ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler (ValidationException.class)
	public ResponseEntity<?> validationException(ValidationException ex, WebRequest request){
		ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
	}
}
