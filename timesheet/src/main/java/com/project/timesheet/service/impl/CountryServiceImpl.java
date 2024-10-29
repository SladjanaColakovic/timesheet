package com.project.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.exception.CategoryNotFoundException;
import com.project.timesheet.exception.CountryNotFoundException;
import com.project.timesheet.model.Country;
import com.project.timesheet.repository.CountryRepository;
import com.project.timesheet.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository repository;

	@Override
	public Country create(Country country) {
		return repository.save(country);
	}

	@Override
	public Country getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new CountryNotFoundException());
	}

	@Override
	public List<Country> getAll() {
		return repository.findAll();
	}

	@Override
	public Country update(Country country) {
		Country existingCountry = repository.findById(country.getId()).orElseThrow(() -> new CountryNotFoundException());
		existingCountry.setName(country.getName());
		return repository.save(existingCountry);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
