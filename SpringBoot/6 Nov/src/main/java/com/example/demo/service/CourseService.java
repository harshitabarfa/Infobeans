package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Optional<Course> getCourseById(Long id) {
		return courseRepository.findById(id);
	}

	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course updateCourse(Long id, Course courseDetails) {
		List<Course> list = courseRepository.findAll();

		Iterator<Course> iterator = list.iterator();
		while (iterator.hasNext()) {
			Course c = iterator.next();

			if (c.getCourseId().equals(id)) {
				c.setCourseName(courseDetails.getCourseName());
				c.setInstructorName(courseDetails.getInstructorName());
				c.setCategory(courseDetails.getCategory());
				c.setFees(courseDetails.getFees());
				c.setStatus(courseDetails.getStatus());
				return courseRepository.save(c);
			}
		}
		return null;
	}

	public boolean deleteCourse(Long id) {
		if (courseRepository.existsById(id)) {
			courseRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Course> getByCourseName(String name) {
		return courseRepository.findByCourseNameIgnoreCase(name);
	}

	public List<Course> getByCategory(String category) {
		return courseRepository.findByCategoryIgnoreCase(category);
	}

	public List<Course> getByInstructor(String instructor) {
		return courseRepository.findByInstructorNameIgnoreCase(instructor);
	}

	public List<Course> getByStatus(String status) {
		return courseRepository.findByStatusIgnoreCase(status);
	}

	public List<Course> findByCourseNameInstructorCategoryFeesAndStatus(String courseName, String instructorName,
			String category, Double fees, String status) {

		List<Course> allCourses = getAllCourses();
		List<Course> result = new ArrayList<>();

		for (Course course : allCourses) {

			boolean matchCourseName = (courseName == null || courseName.isEmpty())
					|| course.getCourseName().equalsIgnoreCase(courseName);

			boolean matchInstructor = (instructorName == null || instructorName.isEmpty())
					|| course.getInstructorName().equalsIgnoreCase(instructorName);

			boolean matchCategory = (category == null || category.isEmpty())
					|| course.getCategory().equalsIgnoreCase(category);

			boolean matchFees = (fees == null || fees == 0) || Double.compare(course.getFees(), fees) == 0;

			boolean matchStatus = (status == null || status.isEmpty()) || course.getStatus().equalsIgnoreCase(status);

			if (matchCourseName && matchInstructor && matchCategory && matchFees && matchStatus) {
				result.add(course);
			}
		}
		return result;
	}
}