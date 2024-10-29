package com.project.timesheet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<?> categoryNotFoundException(){
		return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}

}