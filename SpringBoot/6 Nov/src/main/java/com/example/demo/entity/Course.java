package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;

	private String courseName;
	private String instructorName;
	private String category;
	private double fees;
	private String status;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Course() {
		super();
	}

	public Course(Long courseId, String courseName, String instructorName, String category, double fees,
			String status) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructorName = instructorName;
		this.category = category;
		this.fees = fees;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", instructorName=" + instructorName
				+ ", category=" + category + ", fees=" + fees + ", status=" + status + "]";
	}
}
