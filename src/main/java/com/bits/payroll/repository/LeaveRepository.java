package com.bits.payroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.bits.payroll.model.Leave;

public interface LeaveRepository extends CrudRepository<Leave,Long> {
	

}
