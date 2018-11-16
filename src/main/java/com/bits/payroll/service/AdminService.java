package com.bits.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.payroll.model.Employee;
import com.bits.payroll.repository.EmployeeRepository;

@Service
public class AdminService {
	
	@Autowired
	EmployeeRepository repository;
	
	public boolean loginAdmin(String email,String password) {
		if(email.equals("admin@gmail.com") && password.equals("123456"))
			return true;
		else
			return false;
	}
	
	public boolean registerEmployee(Employee newEmployee) {
		String newPassword = new AppUtils().encryptPassword(newEmployee.getPassword());
		newEmployee.setPassword(newPassword);
		
		Employee temp = repository.getEmployeeByEmail(newEmployee.getEmail());
		System.out.println(temp);
		if(temp==null) {
			repository.save(newEmployee);
			return true;
		}		
		else
			return false;
	}
	
	public Employee getEmployeeByEmail(String email) {
		return repository.getEmployeeByEmail(email);
	}
	
	public void updateEmployee(Employee employee) {
		Employee emp = repository.getEmployeeByEmail(employee.getEmail());
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setSex(employee.getSex());
		emp.setDepartment(employee.getDepartment());
		emp.setDesignation(employee.getDesignation());
		emp.setManagerId(employee.getManagerId());
		emp.setLeaveBalance(employee.getLeaveBalance());
		System.out.println("This is the updated employee details : " +emp);
		repository.save(emp);
	}
}
