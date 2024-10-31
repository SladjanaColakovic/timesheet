package com.project.timesheet.controller;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.timesheet.dto.ReportDto;
import com.project.timesheet.helper.Report;
import com.project.timesheet.helper.ReportSearch;
import com.project.timesheet.service.ReportService;

@RestController
@RequestMapping(value = "/api/report")
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<?> report(@RequestParam(value = "startDate", required = false) LocalDate startDate,
			@RequestParam(value = "endDate", required = false) LocalDate endDate,
			@RequestParam(value = "clientId", required = false) Long clientId,
			@RequestParam(value = "projectId", required = false) Long projectId,
			@RequestParam(value = "categoryId", required = false) Long categoryId,
			@RequestParam(value = "employeeId", required = false) Long employeeId){
		ReportSearch reportSearch = new ReportSearch(clientId, projectId, categoryId, employeeId, startDate, endDate);
		Report result = service.getReport(reportSearch);
		return new ResponseEntity<>(mapper.map(result, ReportDto.class), HttpStatus.OK);
	}

}
