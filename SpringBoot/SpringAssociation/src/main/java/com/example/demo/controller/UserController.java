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

import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		User user1 = userService.createUser(user);
		return ResponseEntity.status(201).body(user1);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(id, user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok("User deleted successfully!");
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@PostMapping("/{id}/profile")
	public ResponseEntity<?> addProfile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
		return ResponseEntity.ok(userService.addProfileToUser(id, userProfile));
	}
	
	@PutMapping("/{id}/profile")
	public ResponseEntity<User> updateProfile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
		return ResponseEntity.ok(userService.updateProfile(id, userProfile));
	}
	
	@GetMapping("/{id}/profile")
	public ResponseEntity<UserProfile> getProfile(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getProfile(id));
	}
	
	@DeleteMapping("/{id}/profile")
	public ResponseEntity<?> deleteProfile(@PathVariable Long id) {
		userService.deleteProfile(id);
		return ResponseEntity.ok("Profile deleted successfully!");
	}
	
	@GetMapping("email/{email}")
	public ResponseEntity<List<User>> get(@PathVariable String email) {
		return ResponseEntity.ok(userService.getUsersByEmail(email));
	}
	
	@GetMapping("/profile")
	public ResponseEntity<List<UserProfile>> getProfilesByAddress(@RequestParam String address) {
	    return ResponseEntity.ok(userService.getProfilesByAddress(address));
	}
}
