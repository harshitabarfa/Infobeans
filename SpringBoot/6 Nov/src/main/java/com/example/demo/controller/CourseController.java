package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> list = courseService.getAllCourses();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Long id) {
		Optional<Course> course = courseService.getCourseById(id);
		if (course.isPresent()) {
			return ResponseEntity.ok(course.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found!");
		}
	}

	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		Course added = courseService.addCourse(course);
		if (added != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add course!");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		Course updated = courseService.updateCourse(id, course);
		if (updated != null) {
			return ResponseEntity.ok("Course updated successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found!");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
		boolean deleted = courseService.deleteCourse(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Course deleted successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found!");
		}
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name) {
		List<Course> list = courseService.getByCourseName(name);
		return list.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(list);
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<?> getByCategory(@PathVariable String category) {
		List<Course> list = courseService.getByCategory(category);
		return list.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(list);
	}

	@GetMapping("/instructor/{instructor}")
	public ResponseEntity<?> getByInstructor(@PathVariable String instructor) {
		List<Course> list = courseService.getByInstructor(instructor);
		return list.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(list);
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<?> getByStatus(@PathVariable String status) {
		List<Course> list = courseService.getByStatus(status);
		return list.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(list);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Course>> searchCourses(@RequestParam(required = false) String courseName,
			@RequestParam(required = false) String instructorName, @RequestParam(required = false) String category,
			@RequestParam(required = false) Double fees, @RequestParam(required = false) String status) {

		List<Course> result = courseService.findByCourseNameInstructorCategoryFeesAndStatus(courseName, instructorName,
				category, fees, status);

		return ResponseEntity.ok(result);
	}
}
