package com.info.CitizenPassport;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String number;
	private LocalDate issuedate;

	@OneToOne(mappedBy = "passport")
	private Citizen citizen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getIssueDate() {
		return issuedate;
	}

	public void setIssueDate(LocalDate issuedate) {
		this.issuedate = issuedate;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passport(int id, String number, LocalDate issuedate, Citizen citizen) {
		super();
		this.id = id;
		this.number = number;
		this.issuedate = issuedate;
		this.citizen = citizen;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", issuedate=" + issuedate + ", citizen=" + citizen + "]";
	}
}
