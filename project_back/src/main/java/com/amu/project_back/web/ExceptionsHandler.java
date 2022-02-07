package com.amu.project_back.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionsHandler {
	
//	public String getMessageProperties(String key) {
//		@Value("${app.title}")
//		String msg;
//		return null;
//	}
	
	

	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<Map<String, String>> constraintViolationHandler(ConstraintViolationException e){
		Map<String, String> listErreur = new HashMap<String, String>();
		e.getConstraintViolations().forEach(violation -> {
			listErreur.put(violation.getPropertyPath().toString(), violation.getMessageTemplate());
		});
		
		return new ResponseEntity<>(listErreur, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	ResponseEntity<Map<String, String>> dataIntegrityViolationHandler(DataIntegrityViolationException e){
		Map<String, String> listErreur = new HashMap<String, String>();
		listErreur.put("username", "Ce nom d'utilisateur existe déja !");
		
		return new ResponseEntity<>(listErreur, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	ResponseEntity<String> badCredentialHandler(){
		
		return new ResponseEntity<>("Username ou Password incorrect", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InternalAuthenticationServiceException.class)
	ResponseEntity<String> internalAuthenticationServiceExceptionHandler(){
		return new ResponseEntity<>("Username ou Password incorrect", HttpStatus.BAD_REQUEST);
	}
	

	
}
