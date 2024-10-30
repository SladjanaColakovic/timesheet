package com.project.timesheet.service;

import java.util.List;

import com.project.timesheet.model.Employee;


public interface EmployeeService {
	Employee create(Employee employee);
	Employee getById(Long id);
	List<Employee> getAll();
	Employee update(Employee employee);
	void delete(Long id);
}
