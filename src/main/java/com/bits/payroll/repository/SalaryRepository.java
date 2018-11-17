package com.bits.payroll.repository;

import java.time.Month;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Salary;

public interface SalaryRepository extends CrudRepository<Salary,Long> {
	
	@Query("select s from Salary s where s.employee=?1 AND s.month=?2 AND s.year=?3")
	public Salary getSalary(@PathParam(value ="employee") Employee employee , @PathParam(value="month") Month month , @PathParam(value="year") int year);
	
	@Query("select s from Salary s where s.employee=?1 AND s.year=?2")
	public List<Salary> getYearlySalary(@PathParam(value ="employee") Employee employee , @PathParam(value="year") int year);
}
