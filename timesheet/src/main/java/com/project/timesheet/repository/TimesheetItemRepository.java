package com.project.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.timesheet.helper.ReportSearch;
import com.project.timesheet.model.TimesheetItem;

@Repository
public interface TimesheetItemRepository extends JpaRepository<TimesheetItem, Long>{
	
	@Query("select i from TimesheetItem i where "
			+ "(coalesce(:#{#reportSearch.startDate}, null) is null OR i.date >= :#{#reportSearch.startDate}) AND"
			+ "(coalesce(:#{#reportSearch.endDate}, null) is null OR i.date <= :#{#reportSearch.endDate}) AND"
			+ "(:#{#reportSearch.clientId} is null OR i.client.id = :#{#reportSearch.clientId}) AND"
			+ "(:#{#reportSearch.projectId} is null OR i.project.id = :#{#reportSearch.projectId}) AND"
			+ "(:#{#reportSearch.categoryId} is null OR i.category.id = :#{#reportSearch.categoryId}) AND"
			+ "(:#{#reportSearch.employeeId} is null OR i.employee.id = :#{#reportSearch.employeeId})")
	List<TimesheetItem> getReport(ReportSearch reportSearch);

}
