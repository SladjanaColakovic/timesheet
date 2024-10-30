package com.project.timesheet.service;

import java.util.List;

import com.project.timesheet.model.Project;


public interface ProjectService {
	Project create(Project project);
	Project getById(Long id);
	List<Project> getAll();
	Project update(Project project);
	void delete(Long id);
}
