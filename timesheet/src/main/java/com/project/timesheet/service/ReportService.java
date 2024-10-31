package com.project.timesheet.service;

import java.util.List;

import com.project.timesheet.model.TimesheetItem;

public interface ReportService {
	List<TimesheetItem> getReport();
}
