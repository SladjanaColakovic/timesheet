package com.project.timesheet.service;

import com.project.timesheet.model.TimesheetItem;

public interface TimesheetItemService {
	TimesheetItem create(TimesheetItem timesheetItem);
	TimesheetItem update(TimesheetItem timesheetItem);
	void delete(Long id);
}
