package com.project.timesheet.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReportDto {
	List<ReportItemDto> items;
	private double totalTime;
}
