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

import com.project.timesheet.dto.ClientDto;
import com.project.timesheet.dto.NewClientDto;
import com.project.timesheet.dto.UpdateClientDto;
import com.project.timesheet.model.Client;
import com.project.timesheet.service.ClientService;

@RestController
@RequestMapping(value = "/api/client")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NewClientDto newClient){
		Client mappedClient = mapper.map(newClient, Client.class);
		Client result = service.create(mappedClient);
		return new ResponseEntity<>(mapper.map(result, ClientDto.class), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Client result = service.getById(id);
		return new ResponseEntity<>(mapper.map(result, ClientDto.class), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Client> result = service.getAll();
		return new ResponseEntity<>(result.stream().map(element -> mapper.map(element, ClientDto.class)).collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody UpdateClientDto client){
		Client mappedClient = mapper.map(client, Client.class);
		Client result = service.update(mappedClient);
		return new ResponseEntity<>(mapper.map(result, ClientDto.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
