package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByCourseNameIgnoreCase(String courseName);

	List<Course> findByInstructorNameIgnoreCase(String instructorName);

	List<Course> findByCategoryIgnoreCase(String category);

	List<Course> findByStatusIgnoreCase(String status);
}
