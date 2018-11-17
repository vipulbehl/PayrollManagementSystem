package com.bits.payroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value= {"employeeName","employeeId"})
public class DashboardController {
	@RequestMapping(value="dashboard", method = RequestMethod.GET)
	public String displayDashboard(ModelMap model) {
		if(model.get("employeeId") == null)
			return "home";
		else
			return "dashboard";
	}
}
