package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String department;

	private LocalDate joiningDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	@JsonManagedReference
	private EmployeeDetails details;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public EmployeeDetails getDetails() {
		return details;
	}

	public void setDetails(EmployeeDetails details) {
		this.details = details;
	}

	public Employee() {
		super();
	}

	public Employee(Long employeeId, String name, String email, String department, LocalDate joiningDate,
			EmployeeDetails details) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.department = department;
		this.joiningDate = joiningDate;
		this.details = details;
	}
}
