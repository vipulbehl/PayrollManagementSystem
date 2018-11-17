package com.bits.payroll.model;

import java.time.Month;
import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "attendance")
@EntityListeners(AuditingEntityListener.class)
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Month month;
	private int year;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	private int daysWorked;
	@ManyToOne
	private Employee employee;
	
	public Attendance() {
		super();
	}
	public Attendance(Long id, Month month, int daysWorked, Employee employee,int year) {
		super();
		this.id = id;
		this.month = month;
		this.daysWorked = daysWorked;
		this.employee = employee;
		this.year=year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Month getMonth() {
		return month;
	}
	public void setMonth(Month month) {
		this.month = month;
	}
	public int getDaysWorked() {
		return daysWorked;
	}
	public void setDaysWorked(int daysWorked) {
		this.daysWorked = daysWorked;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", month=" + month + ", daysWorked=" + daysWorked + ", employee=" + employee
				+ "]";
	}
	
}
