package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;

	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department dept) {
		return ResponseEntity.status(HttpStatus.CREATED).body(deptService.addDept(dept));
	}

	@PostMapping("/{deptId}/employees")
	public ResponseEntity<Employee> addEmployee(@PathVariable Long deptId, @RequestBody Employee emp) {
		return ResponseEntity.status(HttpStatus.CREATED).body(deptService.addEmployeeToDepartment(deptId, emp));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable Long id) {
		return ResponseEntity.ok(deptService.getDept(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> getAll(){
		return ResponseEntity.ok(deptService.getAllDept());
	}
	
	@GetMapping("/list/{deptId}/employees")
	public ResponseEntity<List<Employee>> getEmployees(@PathVariable Long deptId){
		return ResponseEntity.ok(deptService.getEmployeeByDept(deptId));
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteDept(@PathVariable Long id){
		deptService.delteDept(id);
		return ResponseEntity.ok("Department deleted successfully!");
	}
	
	@GetMapping("/{deptId}/count")
	public ResponseEntity<Integer> getEmployeesCount(@PathVariable Long deptId){
		return ResponseEntity.ok(deptService.countEmployee(deptId));
	}
}
