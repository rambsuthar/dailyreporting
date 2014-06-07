package com.gsli.dr.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsli.dr.domain.service.DailyReportService;

@Controller
public class ReportsController {
	
	@Autowired
	private DailyReportService dailyReportService;
	
	@RequestMapping(value = "/dailyReports.htm", method = {RequestMethod.POST,RequestMethod.GET})

	public String showDialyReports(HttpServletRequest request, ModelMap model) {
		
		return "dailyReport";
	}

	public DailyReportService getDailyReportService() {
		return dailyReportService;
	}

	public void setDailyReportService(DailyReportService dailyReportService) {
		this.dailyReportService = dailyReportService;
	}

}
