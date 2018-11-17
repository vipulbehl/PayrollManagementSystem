package com.bits.payroll.controller;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="tax", method = RequestMethod.GET)
	public String showTaxPage() {
		return "tax";
	}
	
}
