package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	List<Recipe> findByNameContainingIgnoreCase(String name);

	List<Recipe> findByCuisineIgnoreCaseAndDifficultyIgnoreCase(String cuisine, String difficulty);

	List<Recipe> findByRatingGreaterThanEqual(Double minRating);

	List<Recipe> findByPrepTimeBetween(Integer minTime, Integer maxTime);

	List<Recipe> findByVegetarian(Boolean vegetarian);

	List<Recipe> findAllByOrderByRatingDesc();

	Long countByCuisineIgnoreCase(String cuisine);

	boolean existsByNameIgnoreCase(String name);

	Long deleteByNameIgnoreCase(String name);

	Long deleteByCuisineIgnoreCase(String cuisine);

	List<Recipe> findByCreatedByIgnoreCase(String createdBy);

	List<Recipe> findByCuisineIgnoreCaseAndRatingGreaterThanEqualAndPrepTimeLessThanEqualAndVegetarian(String cuisine,
			Double minRating, Integer maxTime, Boolean vegetarian);

	List<Recipe> findTop5ByOrderByRatingDesc();

	List<Recipe> findTop3ByOrderByCreatedAtDesc();
}