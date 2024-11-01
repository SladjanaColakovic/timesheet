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
	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<?> countryNotFoundException(){
		return new ResponseEntity<>("Country not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<?> clientNotFoundException(){
		return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> employeeNotFoundException(){
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProjectNotFoundException.class)
	public ResponseEntity<?> projectNotFoundException(){
		return new ResponseEntity<>("Project not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TimesheetItemNotFoundException.class)
	public ResponseEntity<?> timesheetItemNotFoundException(){
		return new ResponseEntity<>("Timesheet item not found", HttpStatus.NOT_FOUND);
	}

}
