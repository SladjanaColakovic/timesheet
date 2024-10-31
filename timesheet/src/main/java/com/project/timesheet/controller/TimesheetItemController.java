package com.project.timesheet.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timesheet.dto.NewTimesheetItemDto;
import com.project.timesheet.dto.TimesheetItemDto;
import com.project.timesheet.dto.UpdateTimesheetItemDto;
import com.project.timesheet.model.TimesheetItem;
import com.project.timesheet.service.TimesheetItemService;

@RestController
@RequestMapping(value = "/api/timesheet")
public class TimesheetItemController {

	@Autowired
	private TimesheetItemService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NewTimesheetItemDto newTimesheetItem){
		TimesheetItem mappedItem = mapper.map(newTimesheetItem, TimesheetItem.class);
		TimesheetItem result = service.create(mappedItem);
		return new ResponseEntity<>(mapper.map(result, TimesheetItemDto.class), HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody UpdateTimesheetItemDto timesheetItem){
		TimesheetItem mappedItem = mapper.map(timesheetItem, TimesheetItem.class);
		TimesheetItem result = service.update(mappedItem);
		return new ResponseEntity<>(mapper.map(result, TimesheetItemDto.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
