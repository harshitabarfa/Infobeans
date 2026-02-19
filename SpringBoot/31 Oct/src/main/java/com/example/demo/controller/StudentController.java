package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.entity.Product;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		List<Student> list = studentService.getAllStudent();
		return list;
	}

	@PostMapping("/addStudents")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/getStudentByDepartment/{department}")
	public List<Student> getStudentByDepartment(@PathVariable String department) {
		return studentService.getStudentByDepartment(department);
	}

	@DeleteMapping("/removeStudent/{id}")
	public String removeStudent(@PathVariable int id) {
		return studentService.removeStudent(id);
	}

	@GetMapping("/topper")
	public Student getTopper() {
		return studentService.getTopper();
	}

	@GetMapping("/average")
	public double getAverage() {
		return studentService.getAverageMarks();
	}

	@GetMapping("/count")
	public int getStudentCount() {
		return studentService.getStudentCount();
	}

	@PutMapping("/updateById/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		return studentService.updateStudent(student, id);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Student>> searchStudents(@RequestParam(required = false) String name,
			@RequestParam(required = false) String department, @RequestParam(required = false) Double marks) {
		List<Student> p = studentService.findByNameDepartmentAndMarks(name, department, marks);
		return ResponseEntity.status(200).body(p);
	}
}
