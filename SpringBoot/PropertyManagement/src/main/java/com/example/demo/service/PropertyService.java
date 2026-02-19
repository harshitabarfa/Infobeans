package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;

import jakarta.transaction.Transactional;

@Service
public class PropertyService {
	private final PropertyRepository repo;

	public PropertyService(PropertyRepository repo) {
		this.repo = repo;
	}

	public Property save(Property p) {
		return repo.save(p);
	}

	public List<Property> getAll() {
		return repo.findAll();
	}

	public List<Property> searchByTitle(String title) {
		return repo.findByTitleContainingIgnoreCase(title);
	}

	public List<Property> byCity(String city) {
		return repo.findByCityIgnoreCase(city);
	}

	public List<Property> byType(String type) {
		return repo.findByTypeIgnoreCase(type);
	}

	public List<Property> filter(String city, String type) {
		return repo.findByCityIgnoreCaseAndTypeIgnoreCase(city, type);
	}

	public List<Property> byPriceRange(Double minPrice, Double maxPrice) {
		return repo.findByPriceBetween(minPrice, maxPrice);
	}

	public List<Property> byBedrooms(Integer minBedrooms) {
		return repo.findByBedroomsGreaterThanEqual(minBedrooms);
	}

	public List<Property> furnished(Boolean furnished) {
		return repo.findByFurnished(furnished);
	}

	public List<Property> byStatus(String status) {
		return repo.findByStatusIgnoreCase(status);
	}

	public List<Property> sortedByPrice() {
		return repo.findAllByOrderByPriceDesc();
	}

	public Long countByCity(String city) {
		return repo.countByCityIgnoreCase(city);
	}

	public Long countByType(String type) {
		return repo.countByTypeIgnoreCase(type);
	}

	public boolean existsByTitle(String title) {
		return repo.existsByTitleIgnoreCase(title);
	}

	public boolean existsByOwner(String listedBy) {
		return repo.existsByListedByIgnoreCase(listedBy);
	}

	public boolean existsByCityAndType(String city, String type) {
		return repo.existsByCityIgnoreCaseAndTypeIgnoreCase(city, type);
	}

	public boolean existsByCityTypeBedrooms(String city, String type, Integer bedrooms) {
		return repo.existsByCityIgnoreCaseAndTypeIgnoreCaseAndBedrooms(city, type, bedrooms);
	}

	@Transactional
	public Long deleteByTitle(String title) {
		return repo.deleteByTitleIgnoreCase(title);
	}

	public Long deleteByStatus(String status) {
		return repo.deleteByStatusIgnoreCase(status);
	}

	public Long deleteByCity(String city) {
		return repo.deleteByCityIgnoreCase(city);
	}

	public List<Property> byOwner(String listedBy) {
		return repo.findByListedByIgnoreCase(listedBy);
	}

	public List<Property> filterByMultiple(String city, Double minPrice, Double maxPrice, Boolean furnished) {
		return repo.findByCityIgnoreCaseAndPriceBetweenAndFurnished(city, minPrice, maxPrice, furnished);
	}

	public List<Property> top5() {
		return repo.findTop5ByOrderByPriceDesc();
	}

	public List<Property> latest3() {
		return repo.findTop3ByOrderByCreatedAtDesc();
	}
}
