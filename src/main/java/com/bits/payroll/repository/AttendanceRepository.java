package com.bits.payroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.bits.payroll.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long>{

}
