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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return students.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(students);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return ResponseEntity.ok(studentService.updateStudent(id, student));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public ResponseEntity<List<Student>> searchByName(@RequestParam String name) {
		List<Student> students = studentService.searchByName(name);
		return students.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(students);
	}

	@GetMapping("/exists")
	public ResponseEntity<Boolean> emailExists(@RequestParam String email) {
		return ResponseEntity.ok(studentService.emailExists(email));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> countStudents() {
		return ResponseEntity.ok(studentService.countStudents());
	}

	@DeleteMapping("/by-email")
	public ResponseEntity<Void> deleteByEmail(@RequestParam String email) {
		studentService.deleteByEmail(email);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/sorted")
	public ResponseEntity<List<Student>> sortedStudents(@RequestParam String sortBy,
			@RequestParam(defaultValue = "asc") String order) {
		return ResponseEntity.ok(studentService.sortedStudents(sortBy, order));
	}
}
