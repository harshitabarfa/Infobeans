package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Enrollments;
import com.example.demo.service.EnrollmentService;

@RestController
@RequestMapping("/students/{studentId}/enrollments")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;

	@PostMapping
	public ResponseEntity<Enrollments> addEnrollment(@PathVariable Long studentId,
			@RequestBody Enrollments enrollment) {
		return new ResponseEntity<>(enrollmentService.addEnrollment(studentId, enrollment), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Enrollments>> getEnrollments(@PathVariable Long studentId) {
		return ResponseEntity.ok(enrollmentService.getEnrollments(studentId));
	}

	@DeleteMapping("/{enrollId}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable Long studentId, @PathVariable Long enrollId) {
		enrollmentService.deleteEnrollment(studentId, enrollId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{enrollId}/move/{newStudentId}")
	public ResponseEntity<Enrollments> moveEnrollment(@PathVariable Long newStudentId, @PathVariable Long enrollId) {
		return ResponseEntity.ok(enrollmentService.moveEnrollment(newStudentId, enrollId));
	}
}
