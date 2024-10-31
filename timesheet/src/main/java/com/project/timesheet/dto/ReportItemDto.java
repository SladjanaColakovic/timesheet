package com.project.timesheet.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReportItemDto {
	private LocalDate date;
	private ReportClientDto client;
	private ReportProjectDto project;
	private ReportEmployeeDto employee;
	private ReportCategoryDto category;
	private String description;
	private double time;
}
