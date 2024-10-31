package com.project.timesheet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.exception.TimesheetItemNotFoundException;
import com.project.timesheet.model.TimesheetItem;
import com.project.timesheet.repository.TimesheetItemRepository;
import com.project.timesheet.service.TimesheetItemService;

@Service
public class TimesheetItemServiceImpl implements TimesheetItemService{
	
	@Autowired
	private TimesheetItemRepository repository;

	@Override
	public TimesheetItem create(TimesheetItem timesheetItem) {
		return repository.save(timesheetItem);
	}

	@Override
	public TimesheetItem update(TimesheetItem timesheetItem) {
		TimesheetItem existingItem = repository.findById(timesheetItem.getId()).orElseThrow(() -> new TimesheetItemNotFoundException());
		existingItem.setDescription(timesheetItem.getDescription());;
		existingItem.setHours(timesheetItem.getHours());
		existingItem.setOvertime(timesheetItem.getOvertime());
		existingItem.setClient(timesheetItem.getClient());
		existingItem.setProject(timesheetItem.getProject());
		existingItem.setCategory(timesheetItem.getCategory());
		existingItem.setEmployee(timesheetItem.getEmployee());
		return repository.save(existingItem);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	

}
