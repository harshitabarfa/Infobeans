package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Enrollments;
import com.example.demo.entity.Student;
import com.example.demo.exception.DuplicateCourseException;
import com.example.demo.exception.EnrollmentNotFoundException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class EnrollmentService {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private EnrollmentRepository enrollmentRepo;

	public Enrollments addEnrollment(Long studentId, Enrollments enrollment) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student ID " + studentId + " not found"));

		boolean duplicate = student.getEnrollments().stream()
				.anyMatch(e -> e.getCourse().equalsIgnoreCase(enrollment.getCourse()));
		if (duplicate) {
			throw new DuplicateCourseException("Student already enrolled in course: " + enrollment.getCourse());
		}
		enrollment.setStudent(student);
		student.getEnrollments().add(enrollment);
		return enrollmentRepo.save(enrollment);
	}

	public List<Enrollments> getEnrollments(Long studentId) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student ID " + studentId + " not found"));

		if (student.getEnrollments().isEmpty()) {
			throw new EnrollmentNotFoundException("No enrollments found for student ID " + studentId);
		}
		return student.getEnrollments();
	}

	public void deleteEnrollment(Long studentId, Long enrollmentId) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student ID " + studentId + " not found"));

		Enrollments enrollment = enrollmentRepo.findById(enrollmentId)
				.orElseThrow(() -> new EnrollmentNotFoundException("Enrollment ID " + enrollmentId + " not found"));

		if (!enrollment.getStudent().getStudentId().equals(studentId)) {
			throw new EnrollmentNotFoundException("Enrollment does not belong to student ID " + studentId);
		}
		student.getEnrollments().remove(enrollment);
		enrollmentRepo.delete(enrollment);
	}

	public Enrollments moveEnrollment(Long newStudentId, Long enrollmentId) {
		Student newStudent = studentRepo.findById(newStudentId)
				.orElseThrow(() -> new StudentNotFoundException("Student ID " + newStudentId + " not found"));

		Enrollments enrollment = enrollmentRepo.findById(enrollmentId)
				.orElseThrow(() -> new EnrollmentNotFoundException("Enrollment ID " + enrollmentId + " not found"));

		Student oldStudent = enrollment.getStudent();
		oldStudent.getEnrollments().remove(enrollment);

		boolean duplicate = newStudent.getEnrollments().stream()
				.anyMatch(e -> e.getCourse().equalsIgnoreCase(enrollment.getCourse()));

		if (duplicate) {
			throw new DuplicateCourseException("Student already enrolled in course: " + enrollment.getCourse());
		}

		enrollment.setStudent(newStudent);
		newStudent.getEnrollments().add(enrollment);
		return enrollmentRepo.save(enrollment);
	}
}
