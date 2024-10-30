package com.project.timesheet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timesheet.dto.EmployeeDto;
import com.project.timesheet.dto.NewEmployeeDto;
import com.project.timesheet.dto.UpdateEmployeeDto;
import com.project.timesheet.model.Employee;
import com.project.timesheet.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NewEmployeeDto newEmployee){
		System.out.println("New: " + newEmployee.isActive());
		Employee mappedEmployee = mapper.map(newEmployee, Employee.class);
		System.out.println("Mapped: " + newEmployee.isActive());
		Employee result = service.create(mappedEmployee);
		return new ResponseEntity<>(mapper.map(result, EmployeeDto.class), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Employee result = service.getById(id);
		return new ResponseEntity<>(mapper.map(result, EmployeeDto.class), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Employee> result = service.getAll();
		return new ResponseEntity<>(result.stream().map(element -> mapper.map(element, EmployeeDto.class)).collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody UpdateEmployeeDto employee){
		Employee mappedEmployee = mapper.map(employee, Employee.class);
		Employee result = service.update(mappedEmployee);
		return new ResponseEntity<>(mapper.map(result, EmployeeDto.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
