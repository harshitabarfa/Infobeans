package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LostItem;
import com.example.demo.service.LostItemService;

@RestController
@RequestMapping("/api/lost-items")
@CrossOrigin
public class LostItemController {

	@Autowired
	private LostItemService lostItemService;

	@PostMapping
	public LostItem addLostItem(@RequestBody LostItem item) {
		return lostItemService.saveLostItem(item);
	}

	@GetMapping
	public List<LostItem> getAllLostItems() {
		return lostItemService.getAllLostItems();
	}

	@GetMapping("/{id}")
	public LostItem getLostItem(@PathVariable Long id) {
		return lostItemService.getLostItemById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteLostItem(@PathVariable Long id) {
		lostItemService.deleteLostItem(id);
	}
}
