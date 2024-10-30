package com.project.timesheet.dto;

import com.project.timesheet.definition.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NewEmployeeDto {
	private String name;
	private String username;
	private String password;
	private int hoursPerWeek;
	private String email;
	private boolean isActive;
	private Role role;
}
