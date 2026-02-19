package com.info.CitizenPassport;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;

	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;

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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Citizen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Citizen(int id, String name, int age, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", age=" + age + ", passport=" + passport.getNumber() + ", date=" + passport.getIssueDate() + "]";
	}
}
