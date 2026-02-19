package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Recipe;
import com.example.demo.repository.RecipeRepository;

import jakarta.transaction.Transactional;

@Service
public class RecipeService {
	private final RecipeRepository repo;

	public RecipeService(RecipeRepository repo) {
		this.repo = repo;
	}

	public Recipe save(Recipe recipe) {
		return repo.save(recipe);
	}

	public List<Recipe> getAll() {
		return repo.findAll();
	}

	public List<Recipe> searchByName(String name) {
		return repo.findByNameContainingIgnoreCase(name);
	}

	public List<Recipe> filter(String cuisine, String difficulty) {
		return repo.findByCuisineIgnoreCaseAndDifficultyIgnoreCase(cuisine, difficulty);
	}

	public List<Recipe> byRating(Double minRating) {
		return repo.findByRatingGreaterThanEqual(minRating);
	}

	public List<Recipe> byTime(Integer minTime, Integer maxTime) {
		return repo.findByPrepTimeBetween(minTime, maxTime);
	}

	public List<Recipe> veg(Boolean isVeg) {
		return repo.findByVegetarian(isVeg);
	}

	public List<Recipe> sortedByRating() {
		return repo.findAllByOrderByRatingDesc();
	}

	public Long countByCuisine(String cuisine) {
		return repo.countByCuisineIgnoreCase(cuisine);
	}

	public boolean existsByName(String name) {
		return repo.existsByNameIgnoreCase(name);
	}

	@Transactional
	public Long deleteByName(String name) {
		return repo.deleteByNameIgnoreCase(name.trim());
	}

	public Long deleteByCuisine(String cuisine) {
		return repo.deleteByCuisineIgnoreCase(cuisine);
	}

	public List<Recipe> byCreator(String createdBy) {
		return repo.findByCreatedByIgnoreCase(createdBy);
	}

	public List<Recipe> complexFilter(String cuisine, Double minRating, Integer maxTime, Boolean isVeg) {
		return repo.findByCuisineIgnoreCaseAndRatingGreaterThanEqualAndPrepTimeLessThanEqualAndVegetarian(cuisine,
				minRating, maxTime, isVeg);
	}

	public List<Recipe> top5() {
		return repo.findTop5ByOrderByRatingDesc();
	}

	public List<Recipe> latest3() {
		return repo.findTop3ByOrderByCreatedAtDesc();
	}
}