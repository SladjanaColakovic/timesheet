package com.project.timesheet.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class TimesheetItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate date;
	
	private String description;
	
	private double hours;
	private double overtime;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Project project;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;

}
