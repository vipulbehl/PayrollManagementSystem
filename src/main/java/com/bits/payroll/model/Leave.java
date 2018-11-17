package com.bits.payroll.model;

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
	private String startDate;
	private String endDate;
	private int numberLeaves;
	public int getNumberLeaves() {
		return numberLeaves;
	}
	public void setNumberLeaves(int numberLeaves) {
		this.numberLeaves = numberLeaves;
	}
	@ManyToOne
	private Employee employee;
	
	public Leave() {
		super();
	}
	public Leave(Long id, String startDate, String endDate, int numberLeaves, Employee employee) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employee = employee;
		this.numberLeaves=numberLeaves;
	}
	
	public Leave(String startDate, String endDate, int numberLeaves, Employee employee) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberLeaves = numberLeaves;
		this.employee = employee;
	}
	
	public Leave( String startDate, String endDate, int numberLeaves) {
		super();
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberLeaves=numberLeaves;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
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
