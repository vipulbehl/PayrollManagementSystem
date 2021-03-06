package com.bits.payroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	private Long phoneNo;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Sex sex;
	private String department;
	@Enumerated(EnumType.STRING)
	private Designation designation;
	private Long managerId;
	private int leaveBalance;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String email, String password, Long phoneNo, Sex sex, String department,
			Designation designation, Long managerId, int leaveBalance) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.sex = sex;
		this.department = department;
		this.designation = designation;
		this.managerId = managerId;
		this.leaveBalance = leaveBalance;
	}

	public Employee(Long id, String name, String email, String password, Long phoneNo, Sex sex, String department,
			Designation designation, Long managerId, int leaveBalance) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.sex = sex;
		this.department = department;
		this.designation = designation;
		this.managerId = managerId;
		this.leaveBalance = leaveBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Designation getDesignation() {
		return designation;
	}


	public void setDesignation(Designation designation) {
		this.designation = designation;
	}


	public Long getManagerId() {
		return managerId;
	}


	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	public int getLeaveBalance() {
		return leaveBalance;
	}


	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phoneNo="
				+ phoneNo + ", sex=" + sex + ", department=" + department + ", designation=" + designation
				+ ", managerId=" + managerId + ", leaveBalance=" + leaveBalance + "]";
	}

}
