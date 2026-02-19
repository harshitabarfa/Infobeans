package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public class StudentService {
	public static List<Student> list = new ArrayList<>();

	static {
		list.add(new Student(1, "Harshita", "CS", 98));
		list.add(new Student(2, "Mayuri", "IT", 88));
		list.add(new Student(3, "Vanshika", "CS", 78));
	}

	public List<Student> getAllStudent() {
		return list;
	}

	public Student addStudent(Student student) {
		list.add(student);
		return student;
	}

	public Student getStudentById(int id) {
		Iterator<Student> itr = list.iterator();

		Student student = null;
		while (itr.hasNext()) {
			student = itr.next();
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	public List<Student> getStudentByDepartment(String department) {
		List<Student> l = new ArrayList<>();

		Iterator<Student> itr = list.iterator();
		while (itr.hasNext()) {
			Student student = itr.next();
			if (student.getDepartment().equalsIgnoreCase(department)) {
				l.add(student);
			}
		}
		return l;
	}

	public String removeStudent(int id) {
		Iterator<Student> itr = list.iterator();

		Student st = null;
		while (itr.hasNext()) {
			st = itr.next();
			if (st.getId() == id) {
				itr.remove();
				return "Student deleted successfully!";
			}
		}
		return null;
	}

	public Student getTopper() {
		if (list.isEmpty())
			return null;

		Student topper = list.get(0);
		for (Student st : list) {
			if (st.getMarks() > topper.getMarks()) {
				topper = st;
			}
		}
		return topper;
	}

	public double getAverageMarks() {
		if (list.isEmpty())
			return 0.0;

		double total = 0;
		for (Student st : list) {
			total += st.getMarks();
		}
		return total / list.size();
	}

	public int getStudentCount() {
		return list.size();
	}

	public Student updateStudent(Student student, int id) {
		Iterator<Student> itr = list.iterator();

		while (itr.hasNext()) {
			Student s = itr.next();
			if (s.getId() == id) {
				s.setName(student.getName());
				s.setDepartment(student.getDepartment());
				s.setMarks(student.getMarks());
				return student;
			}
		}
		return null;
	}
}
