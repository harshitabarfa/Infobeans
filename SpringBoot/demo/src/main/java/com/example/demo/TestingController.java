package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestingController {
	
	@RequestMapping("/getAll")
	@ResponseBody
	public String handleRequest() {
		return "This is first spring boot project and what you want?";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello guys... How the life is going on?";
	}
}
