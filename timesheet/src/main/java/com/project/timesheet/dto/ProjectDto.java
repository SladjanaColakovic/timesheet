package com.project.timesheet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProjectDto {
	private Long id;
	private String name;
	private String description;
	private ClientDto client;
	private EmployeeDto lead;
	private boolean isActive;
}