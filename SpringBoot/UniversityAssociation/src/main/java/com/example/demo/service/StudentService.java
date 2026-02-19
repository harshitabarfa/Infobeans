package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.exception.AddressNotFoundException;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.InvalidAgeException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private AddressRepository addressRepository;

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student getById(Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
	}

	public Student create(Student student) {
		if (student.getAge() < 16)
			throw new InvalidAgeException("Age must be >= 16");

		studentRepository.findByEmail(student.getEmail()).ifPresent(x -> {
			throw new EmailAlreadyExistsException("Email already exists");
		});

		return studentRepository.save(student);
	}

	public Student update(Long id, Student student) {
		Student st = getById(id);

		st.setName(student.getName());
		st.setAge(student.getAge());
		st.setEmail(student.getEmail());
		st.setDepartment(student.getDepartment());
		st.setAddress(student.getAddress());
		
		if (student.getAddress() != null) {
	        student.getAddress().setStudent(st);
	    }
	    st.setAddress(student.getAddress());

		return studentRepository.save(st);
	}

	public void delete(Long id) {
		if (!studentRepository.existsById(id))
			throw new StudentNotFoundException("Student not found");
		studentRepository.deleteById(id);
	}

	public List<Student> getByDept(String dept) {
		return studentRepository.findByDepartmentIgnoreCase(dept);
	}

	public List<Student> searchByName(String keyword) {
		return studentRepository.findByNameContainingIgnoreCase(keyword);
	}

	public List<Student> minAge(int min) {
		return studentRepository.findByAgeGreaterThanEqual(min);
	}

	public long countDept(String dept) {
		return studentRepository.findByDepartmentIgnoreCase(dept).size();
	}

	public void deleteByEmail(String email) {
		Student st = studentRepository.findByEmail(email)
				.orElseThrow(() -> new StudentNotFoundException("Email not found"));
		studentRepository.delete(st);
	}

	public List<Student> filter(String dept, Integer minAge, String city) {
		return studentRepository.findAll().stream()
				.filter(s -> dept == null || s.getDepartment().equalsIgnoreCase(dept))
				.filter(s -> minAge == null || s.getAge() >= minAge).filter(s -> city == null
						|| (s.getAddress() != null && s.getAddress().getCity().equalsIgnoreCase(city)))
				.toList();
	}

	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	public List<Address> getAddressesByCity(String city) {
		return addressRepository.findByCityIgnoreCase(city);
	}

	public Address getStudentAddress(Long id) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));

		if (student.getAddress() == null)
			throw new AddressNotFoundException("Address not found for student");

		return student.getAddress();
	}

	public Student updateStudentAddress(Long studentId, Address newAddress) {

		if (newAddress == null)
			throw new IllegalArgumentException("Address body cannot be empty");

		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));

		newAddress.setStudent(student);
		student.setAddress(newAddress);

		return studentRepository.save(student);
	}
}
