package com.bits.payroll.service;

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
	
	public boolean applyLeave(Leave newLeave) {
		repository.save(newLeave);
		return true;
	}
	
	public Employee getEmployeeById(Long id) {
		return employeeRepository.getEmployeeById(id);
	}
}
