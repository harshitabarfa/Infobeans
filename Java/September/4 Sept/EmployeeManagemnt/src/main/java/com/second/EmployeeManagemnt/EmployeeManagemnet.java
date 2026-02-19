package com.second.EmployeeManagemnt;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeManagemnet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column(nullable = false, unique = true)
	private String employeeCode;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String department;
	private double salary;
	@Column(nullable = false)
	private String status = "Active";
	private Date joiningDate;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public EmployeeManagemnet() {
		super();
	}

	public EmployeeManagemnet(String employeeCode, String name, String department, double salary, String status,
			Date joiningDate) {
		super();
		this.employeeCode = employeeCode;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.status = status;
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "EmployeeManagemnet [employeeId=" + employeeId + ", employeeCode=" + employeeCode + ", name=" + name
				+ ", department=" + department + ", salary=" + salary + ", status=" + status + ", joiningDate="
				+ joiningDate + "]";
	}
}
