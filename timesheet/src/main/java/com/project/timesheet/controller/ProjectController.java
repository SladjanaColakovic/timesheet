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

import com.project.timesheet.dto.NewProjectDto;
import com.project.timesheet.dto.ProjectDto;
import com.project.timesheet.dto.UpdateProjectDto;
import com.project.timesheet.model.Project;
import com.project.timesheet.service.ProjectService;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NewProjectDto newProject){
		Project mappedProject = mapper.map(newProject, Project.class);
		Project result = service.create(mappedProject);
		return new ResponseEntity<>(mapper.map(result, ProjectDto.class), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Project result = service.getById(id);
		return new ResponseEntity<>(mapper.map(result, ProjectDto.class), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Project> result = service.getAll();
		return new ResponseEntity<>(result.stream().map(element -> mapper.map(element, ProjectDto.class)).collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody UpdateProjectDto project){
		Project mappedProject = mapper.map(project, Project.class);
		Project result = service.update(mappedProject);
		return new ResponseEntity<>(mapper.map(result, ProjectDto.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
