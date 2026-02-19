package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AIMatchResult;
import com.example.demo.service.AIMatchService;

@RestController
@RequestMapping("/api/ai-match")
@CrossOrigin
public class AIMatchController {

	@Autowired
	private AIMatchService matchService;

	@GetMapping("/{lostItemId}")
	public List<AIMatchResult> getMatches(@PathVariable Long lostItemId) {
		return matchService.findMatches(lostItemId);
	}
}
