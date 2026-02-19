package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detailsId;

	private LocalDate dateOfBirth;

	private Integer experience;

	private String phone;

	private String address;

	@OneToOne(mappedBy = "details")
	@JsonBackReference
	private Employee employee;

	public Long getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Long detailsId) {
		this.detailsId = detailsId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(Long detailsId, LocalDate dateOfBirth, Integer experience, String phone, String address,
			Employee employee) {
		super();
		this.detailsId = detailsId;
		this.dateOfBirth = dateOfBirth;
		this.experience = experience;
		this.phone = phone;
		this.address = address;
		this.employee = employee;
	}
}
