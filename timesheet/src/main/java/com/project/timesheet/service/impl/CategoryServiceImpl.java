package com.project.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.exception.CategoryNotFoundException;
import com.project.timesheet.model.Category;
import com.project.timesheet.repository.CategoryRepository;
import com.project.timesheet.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public Category create(Category category) {
		return repository.save(category);
	}

	@Override
	public Category getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
	}

	@Override
	public List<Category> getAll() {
		return repository.findAll();
	}

	@Override
	public Category update(Category category) {
		Category existingCategory = repository.findById(category.getId()).orElseThrow(() -> new CategoryNotFoundException());
		existingCategory.setName(category.getName());
		return repository.save(existingCategory);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
