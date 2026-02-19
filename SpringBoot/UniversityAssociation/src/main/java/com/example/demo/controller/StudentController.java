package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping()
	public ResponseEntity<?> getAllStudents() {
		List<Student> list = studentService.getAll();
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getById(id));
	}

	@PostMapping()
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		Student created = studentService.create(student);
		return ResponseEntity.status(201).body(created);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return ResponseEntity.ok(studentService.update(id, student));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<?> getByDepartment(@PathVariable String department) {
		List<Student> list = studentService.getByDept(department);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/name/{keyword}")
	public ResponseEntity<?> searchByName(@PathVariable String keyword) {
		List<Student> list = studentService.searchByName(keyword);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/age")
	public ResponseEntity<?> getByMinAge(@RequestParam Integer minAge) {
		List<Student> list = studentService.minAge(minAge);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/count/{department}")
	public ResponseEntity<?> countDept(@PathVariable String department) {
		long count = studentService.countDept(department);
		return ResponseEntity.ok(count);
	}

	@DeleteMapping("/email/{email}")
	public ResponseEntity<?> deleteByEmail(@PathVariable String email) {
		studentService.deleteByEmail(email);
		return ResponseEntity.ok("Student deleted with email = " + email);
	}

	@GetMapping("/filter")
	public ResponseEntity<?> filter(@RequestParam(required = false) String department,
			@RequestParam(required = false) Integer minAge, @RequestParam(required = false) String city) {
		List<Student> list = studentService.filter(department, minAge, city);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/addresses")
	public ResponseEntity<?> getAllAddresses() {
		List<Address> list = studentService.getAllAddresses();
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/addresses/city/{city}")
	public ResponseEntity<?> getAddressesByCity(@PathVariable String city) {
		List<Address> list = studentService.getAddressesByCity(city);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/{id}/address")
	public ResponseEntity<?> getStudentAddress(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentAddress(id));
	}

	@PutMapping("/{id}/address")
	public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address address) {
		return ResponseEntity.ok(studentService.updateStudentAddress(id, address));
	}
}
