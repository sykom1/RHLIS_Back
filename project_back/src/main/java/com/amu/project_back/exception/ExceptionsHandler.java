package com.amu.project_back.exception;

import java.util.HashMap;
import java.util.Map;



import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

public class ExceptionsHandler {


	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<Map<String, String>> constraintViolationHandler(ConstraintViolationException e){
		System.out.println("aaa");
		Map<String, String> listErreur = new HashMap<String, String>();
		e.getConstraintViolations().forEach(violation -> {
			listErreur.put(violation.getPropertyPath().toString(), violation.getMessageTemplate());
		});

		return new ResponseEntity<>(listErreur, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	ResponseEntity<Map<String, String>> dataIntegrityViolationHandler(DataIntegrityViolationException e){
		Map<String, String> listErreur = new HashMap<String, String>();
		listErreur.put("email", "Ce mail existe déja !");
		
		return new ResponseEntity<>(listErreur, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	ResponseEntity<String> badCredentialHandler(){
		
		return new ResponseEntity<>("Email ou Password incorrect", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InternalAuthenticationServiceException.class)
	ResponseEntity<String> internalAuthenticationServiceExceptionHandler(){
		return new ResponseEntity<>("Email ou Password incorrect", HttpStatus.BAD_REQUEST);
	}
	

	
}
