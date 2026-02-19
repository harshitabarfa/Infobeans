package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FraudDetectionLog;
import com.example.demo.repository.FraudDetectionLogRepository;

@Service
public class FraudDetectionService {
	@Autowired
	private FraudDetectionLogRepository fraudRepo;

	public FraudDetectionLog logFraud(FraudDetectionLog log) {
		return fraudRepo.save(log);
	}

	public List<FraudDetectionLog> getAllLogs() {
		return fraudRepo.findAll();
	}
}
