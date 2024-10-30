package com.project.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.timesheet.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
