package com.studentEnrollmentSystem.StudentEnrollment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEnrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String rollNumber;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String course;
	@Column(nullable = false, unique = true)
	private String email;
	private int yearOfStudy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public StudentEnrollment() {
		super();
	}

	public StudentEnrollment(String rollNumber, String name, String course, String email, int yearOfStudy) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.course = course;
		this.email = email;
		this.yearOfStudy = yearOfStudy;
	}

	@Override
	public String toString() {
		return "StudentEnrollment [id=" + id + ", rollNumber=" + rollNumber + ", name=" + name + ", course=" + course
				+ ", email=" + email + ", yearOfStudy=" + yearOfStudy + "]";
	}
}
