package com.project.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.model.TimesheetItem;
import com.project.timesheet.repository.TimesheetItemRepository;
import com.project.timesheet.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private TimesheetItemRepository timesheetRepository;
	
	@Override
	public List<TimesheetItem> getReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
