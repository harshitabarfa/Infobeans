package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.MediaFile;
import com.example.demo.service.MediaFileService;

@RestController
@RequestMapping("/api/media")
@CrossOrigin
public class MediaFileController {

	@Autowired
	private MediaFileService mediaService;

	@PostMapping
	public MediaFile save(@RequestBody MediaFile file) {
		return mediaService.save(file);
	}

	@GetMapping
	public List<MediaFile> getAll() {
		return mediaService.getAll();
	}
}
