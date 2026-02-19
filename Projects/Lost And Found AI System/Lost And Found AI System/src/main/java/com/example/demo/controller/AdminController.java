package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
}