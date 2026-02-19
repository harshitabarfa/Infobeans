package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/add")
	public String addPage() {
		return "add";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Student s) {
		service.save(s);
		return "redirect:/";
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("list", service.getAll());
		return "list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		service.delete(id);
		return "redirect:/";
	}
}