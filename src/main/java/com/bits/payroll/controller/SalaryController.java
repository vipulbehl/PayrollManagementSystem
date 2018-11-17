package com.bits.payroll.controller;

import java.security.NoSuchAlgorithmException;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Salary;
import com.bits.payroll.service.SalaryService;

@Controller
@SessionAttributes(value= {"employeeName","employeeId"})
public class SalaryController {
	
	@Autowired
	SalaryService service;
	
	@RequestMapping(value="salary", method = RequestMethod.GET)
	public String showHomePage() {
		return "salary";
	}
	
	
	@RequestMapping(value="getsalary", method = RequestMethod.POST)
	public String getSalary(ModelMap model, @RequestParam Month month, @RequestParam int year)throws NoSuchAlgorithmException {
	
		System.out.println(month);
		System.out.println(year);
		Employee employee = service.getEmployeeById((Long)model.get("employeeId"));
		Salary salary = service.getSalaryByMonth(month,year,employee);
		model.put("salary", salary);
		return "salary";
		
	}

}
