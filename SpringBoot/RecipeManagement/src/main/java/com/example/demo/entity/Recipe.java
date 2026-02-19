package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String cuisine;
	private String difficulty;
	private Integer prepTime;
	private Boolean vegetarian;
	private Double rating;
	private String createdBy;
	private Instant createdAt = Instant.now();

	public Recipe() {
	}

	public Recipe(String name, String cuisine, String difficulty, Integer prepTime, Boolean vegetarian, Double rating,
			String createdBy) {
		this.name = name;
		this.cuisine = cuisine;
		this.difficulty = difficulty;
		this.prepTime = prepTime;
		this.vegetarian = vegetarian;
		this.rating = rating;
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	public Boolean getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}
}
