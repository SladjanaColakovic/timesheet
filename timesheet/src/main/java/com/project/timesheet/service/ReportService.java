package com.project.timesheet.service;


import com.project.timesheet.helper.Report;
import com.project.timesheet.helper.ReportSearch;

public interface ReportService {
	Report getReport(ReportSearch reportSearch);
}
