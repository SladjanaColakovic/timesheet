package com.project.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.exception.ProjectNotFoundException;
import com.project.timesheet.model.Project;
import com.project.timesheet.repository.ProjectRepository;
import com.project.timesheet.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository repository;

	@Override
	public Project create(Project project) {
		return repository.save(project);
	}

	@Override
	public Project getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ProjectNotFoundException());
	}

	@Override
	public List<Project> getAll() {
		return repository.findAll();
	}

	@Override
	public Project update(Project project) {
		Project existingProject = repository.findById(project.getId()).orElseThrow(() -> new ProjectNotFoundException());
		existingProject.setName(project.getName());
		existingProject.setDescription(project.getDescription());
		existingProject.setClient(project.getClient());
		existingProject.setLead(project.getLead());
		existingProject.setActive(project.isActive());
		return repository.save(existingProject);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
