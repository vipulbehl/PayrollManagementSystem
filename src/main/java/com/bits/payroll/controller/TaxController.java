package com.bits.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Salary;
import com.bits.payroll.service.TaxService;

@Controller
@SessionAttributes(value= {"employeeName","employeeId"})
public class TaxController {
	@Autowired
	TaxService service;
	
	
	@RequestMapping(value="getTax", method = RequestMethod.POST)
	public String getTax(@RequestParam int year,ModelMap model)
	{
		
		Employee employee = service.getEmployeeById((Long)model.get("employeeId"));
		List<Salary> salary=service.getYearlySalary(employee, year);
		
		double annualSalary = 0.0;
		//Yahan Employee ki annual Salary generate ho rhi h.
		for(Salary e : salary)
		{		
			annualSalary+= (e.getBasic() + e.getDa() +e.getHra() + e.getTa() - e.getPf());
		}
		
		model.addAttribute("annualSalary", annualSalary);
		System.out.println("Annaul salary "+annualSalary);
		
		//Yahan Par tax calculate kar raha hun different tax brackets hain uske hisab se total tax calculate ho rha h
		 
		double[] maxAmount = {0,100000,300000,500000,800000,2000000};
		double[] taxRate = {0,0.10,0.15,0.25,0.28,0.33};
		double leftSalary = annualSalary;
		double totalTax = 0.0;
		for(int i = 1; i < maxAmount.length && leftSalary > 0; i++) {
		    double taxable_income = Math.min(maxAmount[i]-maxAmount[i-1],leftSalary);
		    totalTax += taxRate[i]*taxable_income;
		    leftSalary -=taxable_income;
		}
		
		double salaryLeft=annualSalary-totalTax;
		
		System.out.println("salaryLeft "+salaryLeft);
		
		System.out.println("totalTax  "+totalTax);
		
		model.addAttribute("salaryLeft", salaryLeft);
		
		model.addAttribute("totalTax", totalTax);
		
		//Yeh Bakchodi Employee ke aukaat ke hisab se plan show karne ke liye.
		if(salaryLeft<=300000)
			model.addAttribute("status", "Tu Gareeb hai saale!!");
		else if(salaryLeft>300000 && salaryLeft<=800000)
			model.addAttribute("status", "Tu middle class hai aur kaam kar!!");
		else
			model.addAttribute("status", "Tu toh Ameer hai Launde Kya baat!!!");
		
		return "panels-wells";
		
	}
	
	@RequestMapping(value="tax", method = RequestMethod.GET)
	public String showTaxPage(ModelMap model) {
		if(model.get("employeeId") == null)
			return "home";
		else
			return "tax";
		
	}
	@RequestMapping(value="panel-wells", method = RequestMethod.GET)
	public String showTaxPage2(ModelMap model) {
		if(model.get("employeeId") == null)
			return "home";
		else
			return "panel-wells";
		
	}
	
}
