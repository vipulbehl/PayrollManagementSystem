package com.bits.payroll.service;

import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.payroll.model.Attendance;
import com.bits.payroll.model.Designation;
import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Salary;
import com.bits.payroll.repository.AttendanceRepository;
import com.bits.payroll.repository.EmployeeRepository;
import com.bits.payroll.repository.SalaryRepository1;

@Service
public class AdminService {
	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	SalaryRepository1 salaryRepository;
	
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
	
	public Employee getEmployeeById(Long id) {
		return repository.getEmployeeById(id);
	}
	
	//Method to add attendance
	public void addAttendance(Attendance attendance) {
		Salary salary = saveSalary(attendance);
		System.out.println(salary);
		salaryRepository.save(salary);
		attendanceRepository.save(attendance);
	}
	
	//Method to calculate salary components and save
	public Salary saveSalary(Attendance attendance) {
		Employee employee = attendance.getEmployee();
		int daysWorked = attendance.getDaysWorked();
		Month month = attendance.getMonth();
		int year = attendance.getYear();
		
		int base = getBasicRate(employee.getDesignation());
		int basic = (int)((base/30)*daysWorked);
		int ta =(int) (basic * 0.1);
		int da = (int) (basic * 0.5);
		int hra = (int) (basic * 0.5);
		int pf = (int) (basic * 0.13);
		
		Salary salary = new Salary(basic,pf,da,hra,ta,month,year,employee);
		return salary;
	}
	
	public int getBasicRate(Designation des) {
		if(des.equals(Designation.Clerk))
			return 20000;
		else if(des.equals(Designation.AssistantManager))
			return 40000;
		else
			return 60000;
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
