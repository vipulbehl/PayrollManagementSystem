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
@Table(name = "salary")
@EntityListeners(AuditingEntityListener.class)
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Month month;
	private int basic;
	private int year;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	private int pf;
	private int da;
	private int hra;
	private int ta;
	@ManyToOne
	private Employee employee;
	
	public Salary() {
		super();
	}
	public Salary(Long id, Month month, int basic, int pf, int da, int hra, int ta, Employee employee, int year) {
		super();
		this.id = id;
		this.month = month;
		this.basic = basic;
		this.pf = pf;
		this.da = da;
		this.hra = hra;
		this.ta = ta;
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
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	public int getDa() {
		return da;
	}
	public void setDa(int da) {
		this.da = da;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public int getTa() {
		return ta;
	}
	public void setTa(int ta) {
		this.ta = ta;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", month=" + month + ", basic=" + basic + ", pf=" + pf + ", da=" + da + ", hra="
				+ hra + ", ta=" + ta + ", employee=" + employee + "]";
	}
	
}
