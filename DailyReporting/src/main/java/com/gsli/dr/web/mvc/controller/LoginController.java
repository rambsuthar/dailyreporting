package com.gsli.dr.web.mvc.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	

	@RequestMapping(value = "/login.htm", method = {RequestMethod.POST,RequestMethod.GET})

	public String showLoginPage(HttpServletRequest request, ModelMap model) {
		
		return "login";
	}

	@RequestMapping(value = "/index.htm", method = {RequestMethod.POST,RequestMethod.GET})

	public String showHomePage(HttpServletRequest request, ModelMap model) {
		
		return "index";
	}

	
}
