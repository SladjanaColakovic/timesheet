package com.project.timesheet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timesheet.helper.Report;
import com.project.timesheet.helper.ReportItem;
import com.project.timesheet.helper.ReportSearch;
import com.project.timesheet.model.TimesheetItem;
import com.project.timesheet.repository.TimesheetItemRepository;
import com.project.timesheet.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private TimesheetItemRepository timesheetRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Report getReport(ReportSearch reportSearch) {
		List<TimesheetItem> timesheetItems = timesheetRepository.getReport(reportSearch);
		List<ReportItem> reportItems = timesheetItems.stream()
				.map(element -> {
					ReportItem item = mapper.map(element, ReportItem.class);
					item.setTime(element.getHours() + element.getOvertime());
					return item;
				})
				.collect(Collectors.toList());
		double totalTime = reportItems.stream().map(ReportItem::getTime).reduce(0.0, Double::sum);
		Report report = new Report(reportItems, totalTime);
		return report;
	}

}
