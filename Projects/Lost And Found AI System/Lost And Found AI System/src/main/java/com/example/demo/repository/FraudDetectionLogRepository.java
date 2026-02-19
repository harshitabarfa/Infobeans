package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FraudDetectionLog;

public interface FraudDetectionLogRepository extends JpaRepository<FraudDetectionLog, Long> {

}
