package com.project.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.timesheet.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}