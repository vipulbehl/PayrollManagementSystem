package com.bits.payroll.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Leave;

public interface LeaveRepository extends CrudRepository<Leave,Long> {
	
	@Query("select l from Leave l where l.employee=?1")
	public List<Leave> getLeaveTransactions(@PathParam(value = "leave") Employee leave);
}
