package com.project.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.timesheet.model.TimesheetItem;

@Repository
public interface TimesheetItemRepository extends JpaRepository<TimesheetItem, Long>{
	
	/*@Query("")
	List<TimesheetItem> getReport();*/

}
