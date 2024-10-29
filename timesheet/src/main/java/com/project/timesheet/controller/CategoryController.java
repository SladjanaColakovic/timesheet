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

import com.project.timesheet.dto.CategoryDto;
import com.project.timesheet.dto.NewCategoryDto;
import com.project.timesheet.dto.UpdateCategoryDto;
import com.project.timesheet.model.Category;
import com.project.timesheet.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NewCategoryDto newCategory){
		Category mappedCategory = mapper.map(newCategory, Category.class);
		Category result = service.create(mappedCategory);
		return new ResponseEntity<>(mapper.map(result, CategoryDto.class), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Category result = service.getById(id);
		return new ResponseEntity<>(mapper.map(result, CategoryDto.class), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Category> result = service.getAll();
		return new ResponseEntity<>(result.stream().map(element -> mapper.map(element, CategoryDto.class)).collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody UpdateCategoryDto category){
		Category mappedCategory = mapper.map(category, Category.class);
		Category result = service.update(mappedCategory);
		return new ResponseEntity<>(mapper.map(result, CategoryDto.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
