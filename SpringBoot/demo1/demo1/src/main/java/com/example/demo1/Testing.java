package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Testing {
	@RequestMapping("/getAll")
	@ResponseBody
	public String greetings() {
		return "Hello Harshii..., Good morning!";
	}
}
