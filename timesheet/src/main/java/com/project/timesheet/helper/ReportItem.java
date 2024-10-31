package com.project.timesheet.helper;

import java.time.LocalDate;

import com.project.timesheet.model.Category;
import com.project.timesheet.model.Client;
import com.project.timesheet.model.Employee;
import com.project.timesheet.model.Project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReportItem {
	private LocalDate date;
	private Client client;
	private Project project;
	private Employee employee;
	private Category category;
	private String description;
	private double time;
}
