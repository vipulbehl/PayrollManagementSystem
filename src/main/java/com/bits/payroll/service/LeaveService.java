package com.bits.payroll.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		
		//Here The LocalDate instance we're making and parsing the startDate format it to ISO i.e yyyy-MM-dd format
		LocalDate d1 = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		long diffDays = diff.toDays();
		return (int)diffDays;
		
	}
}
