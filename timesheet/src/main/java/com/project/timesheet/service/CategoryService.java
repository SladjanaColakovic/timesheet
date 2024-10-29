package com.project.timesheet.service;

import java.util.List;

import com.project.timesheet.model.Category;

public interface CategoryService {

	Category create(Category category);
	Category getById(Long id);
	List<Category> getAll();
	Category update(Category category);
	void delete(Long id);
}
