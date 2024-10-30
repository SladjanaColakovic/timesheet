package com.project.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.exception.EmployeeNotFoundException;
import com.project.timesheet.model.Employee;
import com.project.timesheet.repository.EmployeeRepository;
import com.project.timesheet.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee create(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public Employee update(Employee employee) {
		Employee existingEmployee = repository.findById(employee.getId()).orElseThrow(() -> new EmployeeNotFoundException());
		existingEmployee.setName(employee.getName());
		existingEmployee.setUsername(employee.getUsername());
		existingEmployee.setHoursPerWeek(employee.getHoursPerWeek());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setActive(employee.isActive());
		existingEmployee.setRole(employee.getRole());
		return repository.save(existingEmployee);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

}
