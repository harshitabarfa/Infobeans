package com.second.EmployeeParking;

import jakarta.persistence.CascadeType;
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
	private int id;
	private String name;
	private String dept;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parkingSpotId")
	private Parking ps;

	public Employee() {
		super();
	}

	public Employee(String name, String dept, Parking ps) {
		super();
		this.name = name;
		this.dept = dept;
		this.ps = ps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Parking getPs() {
		return ps;
	}

	public void setPs(Parking ps) {
		this.ps = ps;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", ps=" + ps + "]";
	}
}
