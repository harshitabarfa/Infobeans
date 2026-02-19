package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.FraudDetectionLog;
import com.example.demo.service.FraudDetectionService;

@RestController
@RequestMapping("/api/fraud")
@CrossOrigin
public class FraudDetectionController {

	@Autowired
	private FraudDetectionService fraudService;

	@PostMapping
	public FraudDetectionLog logFraud(@RequestBody FraudDetectionLog log) {
		return fraudService.logFraud(log);
	}

	@GetMapping
	public List<FraudDetectionLog> getAllLogs() {
		return fraudService.getAllLogs();
	}
}
