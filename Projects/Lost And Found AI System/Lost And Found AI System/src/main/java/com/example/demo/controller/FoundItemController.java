package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.FoundItem;
import com.example.demo.service.FoundItemService;

@RestController
@RequestMapping("/api/found-items")
@CrossOrigin
public class FoundItemController {

	@Autowired
	private FoundItemService foundItemService;

	@PostMapping
	public FoundItem addFoundItem(@RequestBody FoundItem item) {
		return foundItemService.saveFoundItem(item);
	}

	@GetMapping
	public List<FoundItem> getAllFoundItems() {
		return foundItemService.getAllFoundItems();
	}

	@GetMapping("/{id}")
	public FoundItem getFoundItem(@PathVariable Long id) {
		return foundItemService.getFoundItemById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteFoundItem(@PathVariable Long id) {
		foundItemService.deleteFoundItem(id);
	}
}
