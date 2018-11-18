package com.bits.payroll.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.payroll.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	@Query("select e from Employee e where e.email=?1 AND e.password=?2")
	public Employee login(@PathParam(value = "email") String email,@PathParam(value = "password") String password);

	//Method to check if an employee with same email id exists
	@Query("select e from Employee e where e.email=?1")
	public Employee getEmployeeByEmail(@PathParam(value = "email") String email);
	
	@Query("select e from Employee e where e.id=?1")
	public Employee getEmployeeById(@PathParam(value="id") Long id);
	
	@Query("select e from Employee e where e.managerId=?1")
	public List<Employee> getSubordinates(@PathParam(value="id")Long id);
	
}
