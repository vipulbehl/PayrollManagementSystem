package com.bits.payroll.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.payroll.model.Employee;
import com.bits.payroll.service.LoginService;

@Controller
@SessionAttributes(value= {"employeeName","employeeId"})
public class LoginController {
	@Autowired
	LoginService service;
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String loginUser(Model model, @RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException{
		System.out.println(email);
		System.out.println(password);
		Employee employee = service.login(email, password);
		
        if (employee==null) {
        	model.addAttribute("err", "Invalid User Credentials!! Please type the credentials again");
        	return "home";
        }
        else {
        	model.addAttribute("employeeName", employee.getName());
        	model.addAttribute("employeeId", employee.getId());
        	return "dashboard";
        }
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
	  session.invalidate();
	  if(model.containsAttribute("employeeId")) {
		  model.asMap().remove("employeeId");
		  model.asMap().remove("employeeName");
	  }
	  return "redirect:home?act=lo";
	}
}
