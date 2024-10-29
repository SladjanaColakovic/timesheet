package com.project.timesheet.service;

import java.util.List;

import com.project.timesheet.model.Country;

public interface CountryService {
	Country create(Country country);
	Country getById(Long id);
	List<Country> getAll();
	Country update(Country country);
	void delete(Long id);
}
