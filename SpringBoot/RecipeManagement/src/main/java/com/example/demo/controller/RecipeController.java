package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Recipe;
import com.example.demo.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	private final RecipeService service;

	public RecipeController(RecipeService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
		if (recipe.getName() == null || recipe.getName().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		Recipe saved = service.save(recipe);
		return ResponseEntity.status(201).body(saved);
	}

	@GetMapping
	public ResponseEntity<List<Recipe>> getAll() {
		List<Recipe> list = service.getAll();
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Recipe>> searchByName(@RequestParam String name) {
		List<Recipe> list = service.searchByName(name);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/filter")
	public ResponseEntity<List<Recipe>> filter(@RequestParam String cuisine, @RequestParam String difficulty) {
		List<Recipe> list = service.filter(cuisine, difficulty);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/by-rating")
	public ResponseEntity<List<Recipe>> byRating(@RequestParam Double minRating) {
		List<Recipe> list = service.byRating(minRating);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/by-time")
	public ResponseEntity<List<Recipe>> byTime(@RequestParam Integer minTime, @RequestParam Integer maxTime) {
		if (minTime > maxTime)
			return ResponseEntity.badRequest().build();
		List<Recipe> list = service.byTime(minTime, maxTime);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/veg")
	public ResponseEntity<List<Recipe>> veg(@RequestParam Boolean isVeg) {
		List<Recipe> list = service.veg(isVeg);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/sorted")
	public ResponseEntity<List<Recipe>> sorted() {
		List<Recipe> list = service.sortedByRating();
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/count")
	public ResponseEntity<Long> countByCuisine(@RequestParam String cuisine) {
		Long count = service.countByCuisine(cuisine);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/exist")
	public ResponseEntity<Void> exists(@RequestParam String name) {
		boolean exists = service.existsByName(name);
		if (!exists)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteByName(@RequestParam String name) {
		Long deleted = service.deleteByName(name);
		if (deleted == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete-by-cuisine")
	public ResponseEntity<Void> deleteByCuisine(@RequestParam String cuisine) {
		Long deleted = service.deleteByCuisine(cuisine);
		if (deleted == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/creator")
	public ResponseEntity<List<Recipe>> byCreator(@RequestParam String createdBy) {
		List<Recipe> list = service.byCreator(createdBy);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/complex-filter")
	public ResponseEntity<List<Recipe>> complexFilter(@RequestParam String cuisine, @RequestParam Double minRating,
			@RequestParam Integer maxTime, @RequestParam Boolean isVeg) {
		List<Recipe> list = service.complexFilter(cuisine, minRating, maxTime, isVeg);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/top")
	public ResponseEntity<List<Recipe>> top() {
		List<Recipe> list = service.top5();
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/latest")
	public ResponseEntity<List<Recipe>> latest() {
		List<Recipe> list = service.latest3();
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}
}
