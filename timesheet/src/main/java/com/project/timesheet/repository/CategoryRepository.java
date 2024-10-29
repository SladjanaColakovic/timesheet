package com.project.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.timesheet.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
