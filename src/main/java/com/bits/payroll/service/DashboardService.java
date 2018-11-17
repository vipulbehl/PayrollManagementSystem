package com.bits.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.payroll.model.Employee;
import com.bits.payroll.repository.EmployeeRepository;

@Service
public class DashboardService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployeeById(Long id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	public List<Employee> getSubordinates(Employee employee) {
		return employeeRepository.getSubordinates(employee.getId());
	}
}
