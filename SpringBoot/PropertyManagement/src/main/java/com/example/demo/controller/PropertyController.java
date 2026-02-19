package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class PropertyController {
	private final PropertyService service;

	public PropertyController(PropertyService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Property> add(@RequestBody Property property) {
		if (property.getTitle() == null || property.getTitle().isBlank())
			return ResponseEntity.badRequest().build();
		Property saved = service.save(property);
		return ResponseEntity.status(201).body(saved);
	}

	@GetMapping
	public ResponseEntity<List<Property>> getAll() {
		List<Property> p = service.getAll();
		if (p.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(p);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Property>> search(@RequestParam String title) {
		List<Property> list = service.searchByTitle(title);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/by-city")
	public ResponseEntity<List<Property>> byCity(@RequestParam String city) {
		List<Property> list = service.byCity(city);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/by-type")
	public ResponseEntity<List<Property>> byType(@RequestParam String type) {
		List<Property> list = service.byType(type);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/filter")
	public ResponseEntity<List<Property>> filter(@RequestParam String city, @RequestParam String type) {
		List<Property> list = service.filter(city, type);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/by-price-range")
	public ResponseEntity<List<Property>> byPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
		if (minPrice > maxPrice)
			return ResponseEntity.badRequest().build();
		List<Property> list = service.byPriceRange(minPrice, maxPrice);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/bedrooms")
	public ResponseEntity<List<Property>> bedrooms(@RequestParam Integer minBedrooms) {
		List<Property> list = service.byBedrooms(minBedrooms);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/furnished")
	public ResponseEntity<List<Property>> furnished(@RequestParam Boolean furnished) {
		List<Property> list = service.furnished(furnished);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/status")
	public ResponseEntity<List<Property>> status(@RequestParam String status) {
		List<Property> list = service.byStatus(status);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/sorted")
	public ResponseEntity<List<Property>> sorted() {
		List<Property> list = service.sortedByPrice();
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/count-by-city")
	public ResponseEntity<Long> countByCity(@RequestParam String city) {
		return ResponseEntity.ok(service.countByCity(city));
	}

	@GetMapping("/count-by-type")
	public ResponseEntity<Long> countByType(@RequestParam String type) {
		return ResponseEntity.ok(service.countByType(type));
	}

	@GetMapping("/exist")
	public ResponseEntity<Void> exists(@RequestParam String title) {
		if (!service.existsByTitle(title))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/exist-by-owner")
	public ResponseEntity<Void> existsByOwner(@RequestParam String listedBy) {
		if (!service.existsByOwner(listedBy))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/exist-by-city-and-type")
	public ResponseEntity<Void> existsByCityAndType(@RequestParam String city, @RequestParam String type) {
		if (!service.existsByCityAndType(city, type))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/exist-by-city-type-bedrooms")
	public ResponseEntity<Void> existsByCityTypeBedrooms(@RequestParam String city, @RequestParam String type,
			@RequestParam Integer bedrooms) {
		if (!service.existsByCityTypeBedrooms(city, type, bedrooms))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete-by-title")
	public ResponseEntity<Void> deleteByTitle(@RequestParam String title) {
		Long deleted = service.deleteByTitle(title);
		if (deleted == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete-by-status")
	public ResponseEntity<Void> deleteByStatus(@RequestParam String status) {
		Long deleted = service.deleteByStatus(status);
		if (deleted == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete-by-city")
	public ResponseEntity<Void> deleteByCity(@RequestParam String city) {
		Long deleted = service.deleteByCity(city);
		if (deleted == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/by-owner")
	public ResponseEntity<List<Property>> byOwner(@RequestParam String listedBy) {
		List<Property> list = service.byOwner(listedBy);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/filter-by-multiple")
	public ResponseEntity<List<Property>> filterByMultiple(@RequestParam String city, @RequestParam Double minPrice,
			@RequestParam Double maxPrice, @RequestParam Boolean furnished) {
		if (minPrice > maxPrice)
			return ResponseEntity.badRequest().build();
		List<Property> list = service.filterByMultiple(city, minPrice, maxPrice, furnished);
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/top")
	public ResponseEntity<List<Property>> top() {
		List<Property> list = service.top5();
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/latest")
	public ResponseEntity<List<Property>> latest() {
		List<Property> list = service.latest3();
		if (list.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}
}
