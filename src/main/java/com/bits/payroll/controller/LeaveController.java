package com.bits.payroll.controller;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Leave;
import com.bits.payroll.service.LeaveService;

@Controller
public class LeaveController {
	
	@Autowired
	LeaveService leaveService;
	
	@RequestMapping(value="leave", method = RequestMethod.POST)
	public String leave(ModelMap model, @RequestParam String startDate, @RequestParam String endDate,@RequestParam int numberLeaves) throws NoSuchAlgorithmException, ParseException{
		System.out.println(startDate.toString());
		System.out.println(endDate.toString());
		Date start = new SimpleDateFormat().parse(startDate);
		Date end = new SimpleDateFormat("yyyy/MM/dd").parse(endDate);
		Leave newLeave = new Leave(start,end,numberLeaves);
		System.out.println(newLeave);
		
        if (newLeave.getNumberLeaves()==0) {
        	model.addAttribute("err", "You've already exhausted the number of leaves limit.");
        	return "home";
        }
        else {
        	Long tempId = (Long)model.get("employeeId");
        	System.out.println(tempId);
        	Employee employee = leaveService.getEmployeeById(tempId);
        	System.out.println(employee);
        	employee.setLeaveBalance(employee.getLeaveBalance()-newLeave.getNumberLeaves());
        	return "dashboard";
        }
	}
	
	@RequestMapping(value="leave", method=RequestMethod.GET)
	public String showLeavePage() {
		return "leave";
	}

}
