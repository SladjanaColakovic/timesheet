package com.project.timesheet.service;

import java.util.List;

import com.project.timesheet.model.Client;


public interface ClientService {
	Client create(Client client);
	Client getById(Long id);
	List<Client> getAll();
	Client update(Client client);
	void delete(Long id);
}
