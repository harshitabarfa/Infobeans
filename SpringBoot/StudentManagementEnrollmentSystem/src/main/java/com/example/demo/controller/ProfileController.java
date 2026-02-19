package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profile;
import com.example.demo.service.ProfileService;

@RestController
@RequestMapping("/students/{studentId}/profile")
public class ProfileController {
	@Autowired
	private ProfileService profileService;

	@PostMapping
	public ResponseEntity<Profile> assignProfile(@PathVariable Long studentId, @RequestBody Profile profile) {
		return new ResponseEntity<>(profileService.assignProfile(studentId, profile), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Profile> getProfile(@PathVariable Long studentId) {
		return ResponseEntity.ok(profileService.getProfile(studentId));
	}

	@PutMapping
	public ResponseEntity<Profile> updateProfile(@PathVariable Long studentId, @RequestBody Profile profile) {
		return ResponseEntity.ok(profileService.updateProfile(studentId, profile));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteProfile(@PathVariable Long studentId) {
		profileService.deleteProfile(studentId);
		return ResponseEntity.noContent().build();
	}
}
