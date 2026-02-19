package mvcDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	@GetMapping("/registerForm")
	public String show() {
		return "registration";
	}
	
	@PostMapping("/register")
	public String submitForm(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "result";
	}
}
