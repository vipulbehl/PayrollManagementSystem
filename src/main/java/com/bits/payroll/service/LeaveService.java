package com.bits.payroll.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Leave;
import com.bits.payroll.repository.EmployeeRepository;
import com.bits.payroll.repository.LeaveRepository;

@Service
public class LeaveService {

	@Autowired
	LeaveRepository repository;

	@Autowired
	EmployeeRepository employeeRepository;

	public boolean applyLeave(String startDate, String endDate, Employee employee) {

		int leaveDays = calculateLeaveDays(startDate, endDate);
		System.out.println(leaveDays);
		
		if (leaveDays <= employee.getLeaveBalance()) {
			Leave leave = new Leave(startDate, endDate, leaveDays, employee);

			// Updating the employee table
			employee.setLeaveBalance(employee.getLeaveBalance() - leaveDays);
			employeeRepository.save(employee);
			
			leave.setEmployee(employee);
			repository.save(leave);

			return true;
		} else
			return false;
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.getEmployeeById(id);
	}

	public int calculateLeaveDays(String startDate, String endDate) {
		
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date start=null,end=null;
		try {
			start = sf.parse(startDate);
			end = sf.parse(endDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		long diff = start.getTime() - end.getTime();
	    return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
}
