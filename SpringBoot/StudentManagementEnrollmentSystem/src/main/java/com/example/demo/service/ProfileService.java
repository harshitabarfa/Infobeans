package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;
import com.example.demo.entity.Student;
import com.example.demo.exception.ProfileNotFoundException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class ProfileService {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private ProfileRepository profileRepo;

	public Profile assignProfile(Long studentId, Profile profile) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student ID " + studentId + " not found"));
		profile.setStudent(student);
		student.setProfile(profile);

		return profileRepo.save(profile);
	}

	public Profile getProfile(Long studentId) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student ID " + studentId + " not found"));

		if (student.getProfile() == null)
			throw new ProfileNotFoundException("Profile not found for this student");

		return student.getProfile();
	}

	public Profile updateProfile(Long studentId, Profile updated) {
		Profile existing = getProfile(studentId);

		existing.setAddress(updated.getAddress());
		existing.setGender(updated.getGender());
		existing.setMobileNumber(updated.getMobileNumber());

		return profileRepo.save(existing);
	}

	public void deleteProfile(Long studentId) {
		Profile profile = getProfile(studentId);
		Student s = profile.getStudent();

		s.setProfile(null);
		profileRepo.delete(profile);
	}
}
