package com.bits.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.payroll.model.Employee;
import com.bits.payroll.repository.EmployeeRepository;

@Service
public class LoginService {
	@Autowired
	EmployeeRepository repository;
	
	public Employee login(String email, String password) {
		String newPassword = new AppUtils().encryptPassword(password);
		System.out.println("the pass is :" +newPassword);
		Employee employee = repository.login(email, newPassword);
		System.out.println(employee);
		return employee;
	}
}
