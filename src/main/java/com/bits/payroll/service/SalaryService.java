package com.bits.payroll.service;

import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Salary;
import com.bits.payroll.repository.EmployeeRepository;
import com.bits.payroll.repository.SalaryRepository;

public class SalaryService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SalaryRepository salaryRepository;

	public Salary getSalaryByMonth(Month month, int year, Employee employee) {

		Salary salary = salaryRepository.getSalary(employee.getId(), month, year);
		return salary;

	}
	
	public Employee getEmployeeById(Long id) {
		return employeeRepository.getEmployeeById(id);
	}
}
