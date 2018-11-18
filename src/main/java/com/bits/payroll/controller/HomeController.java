package com.bits.payroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}
	
	
	@RequestMapping(value="login2", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login2";
	}
	
	/*@RequestMapping(value="EmployeeDashboard", method = RequestMethod.GET)
	public String showPanelPage() {
		return "EmployeeDashboard";
	}*/
	
	@RequestMapping(value="EmployeeDashboard", method = RequestMethod.GET)
	public String showEmployeeDashboard(ModelMap model) {
		if(model.get("employeeId") == null)
			return "login2";
		else
			return "EmployeeDashboard";
		
	}
	
}
