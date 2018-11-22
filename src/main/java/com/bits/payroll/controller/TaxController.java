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
@SessionAttributes(value= {"employeeName","employeeEmail","employeeId"})
public class TaxController {
	@Autowired
	TaxService service;
	
	
	@RequestMapping(value="getTax", method = RequestMethod.POST)
	public String getTax(@RequestParam int year,ModelMap model)
	{
		
		Employee employee = service.getEmployeeById((Long)model.get("employeeId"));
		List<Salary> salary=service.getYearlySalary(employee, year);
		
		double annualSalary = 0.0;
		//Generating employees annual salary
		for(Salary e : salary) {		
			annualSalary+= (e.getBasic() + e.getDa() +e.getHra() + e.getTa() - e.getPf());
		}
		
		model.addAttribute("annualSalary", annualSalary);
		System.out.println("Annaul salary "+annualSalary);
		
		//Calculating tax based on tax brackets
		 
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
		
		//Showing tax benefit plans
		if(salaryLeft<=300000)
			model.addAttribute("status", "From April 1, 2018 any LTCG made on transfer of equity MFs that have an equity exposure of 65 per cent or more including Equity-linked savings schemes (ELSS) will have to pay a 10 per cent tax on long-term gains. It is important to note that gains made above Rs 1 lakh per annum will only be subject to tax and any gains made below that limit in one FY remains tax-exempt. The LTCG made till January 31, 2018, however, remains grandfathered, i.e., those gains remains tax-exempt");
		else if(salaryLeft>300000 && salaryLeft<=800000)
			model.addAttribute("status", "Unit linked insurance plan (Ulip) is a hybrid product, a combo of protection and saving. It not only provides life insurance but also helps channel one's savings into various market-linked assets for meeting long-term goals. \r\n"	);
		else
			model.addAttribute("status", "High Quality Plan");
		
		return "tax";
		
	}
	
	@RequestMapping(value="tax", method = RequestMethod.GET)
	public String showTaxPage(ModelMap model) {
		if(model.get("employeeId") == null)
			return "home";
		else
			return "tax";
		
	}
	/*@RequestMapping(value="tax", method = RequestMethod.GET)
	public String showTaxPage2(ModelMap model) {
		if(model.get("employeeName") == null)
			return "home";
		else
			return "tax";
		
	}*/
	
}
