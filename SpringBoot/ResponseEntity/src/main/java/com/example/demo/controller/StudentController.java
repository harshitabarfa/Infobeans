package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = studentService.getAllStudent();

		if (list == null || list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(list);
	}

	@PostMapping("/addStudents")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student s = studentService.addStudent(student);

		return ResponseEntity.status(HttpStatus.CREATED).body(s);
	}

	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id) {
		Student student = studentService.getStudentById(id);

		if (student != null) {
			return ResponseEntity.ok(student);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
	}

	@GetMapping("/getStudentByDepartment/{department}")
	public ResponseEntity<List<Student>> getStudentByDepartment(@PathVariable String department) {
		List<Student> list = studentService.getStudentByDepartment(department);

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}

	@DeleteMapping("/removeStudent/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable int id) {
		String message = studentService.removeStudent(id);

		if (message != null) {
			return ResponseEntity.ok(message);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
	}

	@GetMapping("/topper")
	public ResponseEntity<?> getTopper() {
		Student topper = studentService.getTopper();

		if (topper != null) {
			return ResponseEntity.ok(topper);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No students available to find topper!");
	}

	@GetMapping("/average")
	public ResponseEntity<Double> getAverage() {
		double avg = studentService.getAverageMarks();

		return ResponseEntity.ok(avg);
	}

	@GetMapping("/count")
	public ResponseEntity<Integer> getStudentCount() {
		int count = studentService.getStudentCount();

		return ResponseEntity.ok(count);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable int id) {
		Student updated = studentService.updateStudent(student, id);

		if (updated != null) {
			return ResponseEntity.ok(updated);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
	}
}
