package com.info.UniversityStudent;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String location;

	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public University(int id, String name, String location, List<Student> student) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.student = student;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", location=" + location + ", student=" + student + "]";
	}
}
