package com.bits.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.payroll.model.Employee;
import com.bits.payroll.service.DashboardService;

@Controller
@SessionAttributes(value= {"employeeName","employeeId"})
public class DashboardController {
	
	@Autowired
	DashboardService service;
	
	@RequestMapping(value="dashboard", method = RequestMethod.GET)
	public String displayDashboard(ModelMap model) {
		if(model.get("employeeId") == null)
			return "home";
		else
			return "dashboard";
	}
	
	@RequestMapping(value="viewSubordinates", method = RequestMethod.GET)
	public String displaySubordinates(ModelMap model) {
		Employee employee = service.getEmployeeById((Long)model.get("employeeId"));
		List<Employee> subordinates= service.getSubordinates(employee);
		model.put("subordinates", subordinates);
		return "viewSubordinates";
	}
}
