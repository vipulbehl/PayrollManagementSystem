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

import com.bits.payroll.model.Attendance;
import com.bits.payroll.model.Designation;
import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Sex;
import com.bits.payroll.service.AdminService;

@Controller
@SessionAttributes(value= {"employeeName","employeeEmail"})
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@RequestMapping(value="adminDashboard", method = RequestMethod.POST)
	public String loginAdmin(Model model, @RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException{
		System.out.println(email);
		System.out.println(password);
		
        if (!service.loginAdmin(email, password)) {
        	model.addAttribute("err", "Invalid User Credentials!! Please type the credentials again");
        	return "home";
        }
        else {
        	model.addAttribute("employeeName", "admin");
        	return "adminDashboard";
        }
	}
	
	// Function to prevent direct access of admin dashboard
	@RequestMapping(value="adminDashboard", method = RequestMethod.GET)
	public String showDashboard(ModelMap model) {
		if(model.get("employeeName") == null)
			return "home";
		else
			return "adminDashboard";
	}
	
	@RequestMapping(value="addEmployee", method = RequestMethod.POST)
	public String addEmployee(ModelMap model,@RequestParam String name,@RequestParam String email,@RequestParam String password,@RequestParam Long phoneNo,@RequestParam String sex,@RequestParam String department,@RequestParam String designation,@RequestParam Long managerId,@RequestParam int leaveBalance) {
		Employee employee = new Employee(name,email,password,phoneNo,Sex.valueOf(sex),department,Designation.valueOf(designation),managerId,leaveBalance);
		System.out.println(employee);
		if(!service.registerEmployee(employee))
			model.addAttribute("err", "User already exists");
		return "adminDashboard";
	}
	
	@RequestMapping(value="updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(ModelMap model, @RequestParam String email) {
		Employee emp = service.getEmployeeByEmail(email);
		model.addAttribute("emp",emp);
		//setting a session variable for employee email
		model.addAttribute("employeeEmail", email);
		return "updateEmployee";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String updateEmployee(ModelMap model,@RequestParam String name,@RequestParam String email,@RequestParam String password,@RequestParam Long phoneNo,@RequestParam String sex,@RequestParam String department,@RequestParam String designation,@RequestParam Long managerId,@RequestParam int leaveBalance) {
		Employee employee = new Employee(name,email,password,phoneNo,Sex.valueOf(sex),department,Designation.valueOf(designation),managerId,leaveBalance);
		System.out.println(employee);	
		service.updateEmployee(employee);
		return "adminDashboard";
	}
	
	@RequestMapping(value="addAttendance", method = RequestMethod.POST)
	public String addAttendance(ModelMap model,@RequestParam int month,@RequestParam int year,@RequestParam int daysWorked) {
		Employee emp = service.getEmployeeByEmail((String)model.get("employeeEmail"));
		System.out.println(emp);
		Month mon = Month.of(month);
		Attendance attendance = new Attendance(mon,year,daysWorked,emp);
		service.addAttendance(attendance);
		return "adminDashboard";
	}
	
}
