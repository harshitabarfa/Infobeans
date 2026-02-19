package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LocationTracking;

public interface LocationTrackingRepository extends JpaRepository<LocationTracking, Long> {

}
