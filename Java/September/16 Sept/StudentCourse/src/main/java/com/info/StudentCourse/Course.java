package com.info.StudentCourse;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Student> student = new ArrayList<>();

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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String name, List<Student> student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", student=" + student + "]";
	}
}
