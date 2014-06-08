package com.gsli.dr.web.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsli.dr.common.util.GSLConstants;
import com.gsli.dr.domain.entity.Client;
import com.gsli.dr.domain.entity.Contractor;
import com.gsli.dr.domain.entity.Vehicle;
import com.gsli.dr.domain.service.ClientService;
import com.gsli.dr.domain.service.ContractorService;
import com.gsli.dr.domain.service.VehicleService;
import com.gsli.dr.web.mvc.model.DailyReportVO;

@Controller
public class LoginController {
	
	@Autowired
	private VehicleService vehicleService;	
	@Autowired
	private ClientService clientService;
	@Autowired
	private ContractorService contractorService;

	@RequestMapping(value = "/login.htm", method = {RequestMethod.POST,RequestMethod.GET})

	public String showLoginPage(HttpServletRequest request, ModelMap model) {
		
		return "login";
	}

	@RequestMapping(value = "/index.htm", method = {RequestMethod.POST,RequestMethod.GET})

	public String showHomePage(HttpServletRequest request, ModelMap model) {
		
		List<Vehicle> vehicleList = vehicleService.findAllEntities();
		List<Client> clientsList = clientService.findAllEntities();
		List<Contractor> contractorList = contractorService.findAllEntities();
		model.addAttribute(GSLConstants.VEHICLES_LIST,vehicleList);
		model.addAttribute(GSLConstants.CLIENTS_LIST,clientsList);
		model.addAttribute(GSLConstants.CONTRACTORS_LIST, contractorList);
		model.addAttribute(GSLConstants.DAILY_REPORT_VO,new DailyReportVO());
		
		return "index";
	}

	
}
