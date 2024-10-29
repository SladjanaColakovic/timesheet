package com.project.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.timesheet.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
