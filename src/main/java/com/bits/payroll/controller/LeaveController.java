package com.bits.payroll.controller;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.payroll.model.Employee;
import com.bits.payroll.service.LeaveService;

@Controller
@SessionAttributes(value= {"employeeName","employeeEmail","employeeId"})
public class LeaveController {
	
	@Autowired
	LeaveService leaveService;
	
	@RequestMapping(value="leave", method = RequestMethod.POST)
	public String leave(ModelMap model, @RequestParam String startDate, @RequestParam String endDate) throws ParseException{
		System.out.println(startDate);
		System.out.println(endDate);
		
		Long empId = (Long)model.get("employeeId");
		Employee employee = leaveService.getEmployeeById(empId);
		
		if(leaveService.applyLeave(startDate,endDate,employee))
			return "EmployeeDashboard";
		else
			return "leave";
		
	}
	
	@RequestMapping(value="leave", method=RequestMethod.GET)
	public String showLeavePage() {
		return "leave";
	}
	
	@RequestMapping(value="leaveTransactions", method=RequestMethod.GET)
	public String showLeaveTransactions(ModelMap model) {
		Long empId = (Long)model.get("employeeId");
		Employee employee = leaveService.getEmployeeById(empId);
		model.put("leaveT",leaveService.getLeaveTransactions(employee));
		return "leaveTransactions";
	}

}
