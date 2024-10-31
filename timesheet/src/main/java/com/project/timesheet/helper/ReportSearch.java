package com.project.timesheet.helper;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportSearch {
	private Long clientId;
	private Long projectId;
	private Long categoryId;
	private Long employeeId;
	private LocalDate startDate;
	private LocalDate endDate;
}
