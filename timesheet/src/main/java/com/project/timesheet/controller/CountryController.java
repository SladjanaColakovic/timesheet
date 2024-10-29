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

import com.project.timesheet.dto.CountryDto;
import com.project.timesheet.dto.NewCountryDto;
import com.project.timesheet.dto.UpdateCountryDto;
import com.project.timesheet.model.Country;
import com.project.timesheet.service.CountryService;

@RestController
@RequestMapping(value = "/api/country")
public class CountryController {

	@Autowired
	private CountryService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NewCountryDto newCountry){
		Country mappedCountry = mapper.map(newCountry, Country.class);
		Country result = service.create(mappedCountry);
		return new ResponseEntity<>(mapper.map(result, CountryDto.class), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Country result = service.getById(id);
		return new ResponseEntity<>(mapper.map(result, CountryDto.class), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Country> result = service.getAll();
		return new ResponseEntity<>(result.stream().map(element -> mapper.map(element, CountryDto.class)).collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody UpdateCountryDto country){
		Country mappedCountry = mapper.map(country, Country.class);
		Country result = service.update(mappedCountry);
		return new ResponseEntity<>(mapper.map(result, CountryDto.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
