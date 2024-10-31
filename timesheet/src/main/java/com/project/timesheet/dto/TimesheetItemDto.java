package com.project.timesheet.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TimesheetItemDto {
	private Long id;
	private LocalDate date;
	private String description;
	private double hours;
	private double overtime;
	private ClientDto client;
	private ProjectDto project;
	private CategoryDto category;
}