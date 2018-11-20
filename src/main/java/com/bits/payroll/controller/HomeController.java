package com.bits.payroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value= {"employeeName","employeeEmail","employeeId"})
public class HomeController {
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}
	
}
