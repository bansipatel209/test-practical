package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<?> getException(ProjectException projectException){
		
		ResonseBean error = new ResonseBean(projectException.getHttpStatus(), projectException.getMessage(), false);
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

}
