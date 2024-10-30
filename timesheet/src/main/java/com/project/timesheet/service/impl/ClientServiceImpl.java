package com.project.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.exception.ClientNotFoundException;
import com.project.timesheet.model.Client;
import com.project.timesheet.repository.ClientRepository;
import com.project.timesheet.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository repository;

	@Override
	public Client create(Client client) {
		return repository.save(client);
	}

	@Override
	public Client getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ClientNotFoundException());
	}

	@Override
	public List<Client> getAll() {
		return repository.findAll();
	}

	@Override
	public Client update(Client client) {
		Client existingClient = repository.findById(client.getId()).orElseThrow(() -> new ClientNotFoundException());
		existingClient.setName(client.getName());
		existingClient.setAddress(client.getAddress());
		existingClient.setCity(client.getCity());
		existingClient.setCountry(client.getCountry());
		existingClient.setPostalCode(client.getPostalCode());
		return repository.save(existingClient);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
