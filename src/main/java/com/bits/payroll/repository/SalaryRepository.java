package com.bits.payroll.repository;

import java.time.Month;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.payroll.model.Salary;

public interface SalaryRepository extends CrudRepository<Salary,Long> {
	
	@Query("select s from salary s where s.employee=?1 AND s.year=?2 AND s.month=?3")
	public Salary getSalary(@PathParam(value ="id") Long id , @PathParam(value="month") Month month , @PathParam(value="year") int year);
}
