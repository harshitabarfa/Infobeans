package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String studentName;
	@Column(unique = true)
	private String email;
	private int age;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Profile profile;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Enrollments> enrollments = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(Long studentId, String studentName, String email, int age, Profile profile,
			List<Enrollments> enrollments) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.age = age;
		this.profile = profile;
		this.enrollments = enrollments;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Enrollments> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}
}
