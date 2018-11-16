package com.bits.payroll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "leaves")
@EntityListeners(AuditingEntityListener.class)
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date startDate;
	private Date endDate;
	@ManyToOne
	private Employee employee;
	
	public Leave() {
		super();
	}
	public Leave(Long id, Date startDate, Date endDate, Employee employee) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employee = employee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Leave [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", employee=" + employee + "]";
	}
	
}
