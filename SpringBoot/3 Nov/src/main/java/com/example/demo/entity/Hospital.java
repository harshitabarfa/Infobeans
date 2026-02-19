package com.example.demo.entity;

public class Hospital {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String disease;
	private double bill;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int id, String name, int age, String gender, String disease, double bill) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.disease = disease;
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", disease=" + disease
				+ ", bill=" + bill + "]";
	}
}
