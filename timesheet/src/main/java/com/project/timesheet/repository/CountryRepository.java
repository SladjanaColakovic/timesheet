package com.project.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.timesheet.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>{

}
