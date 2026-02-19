package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MediaFile;

public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {

}
