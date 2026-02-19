package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
	List<Property> findByCityIgnoreCase(String city);

	List<Property> findByTypeIgnoreCase(String type);

	List<Property> findByCityIgnoreCaseAndTypeIgnoreCase(String city, String type);

	List<Property> findByPriceBetween(Double minPrice, Double maxPrice);

	List<Property> findByBedroomsGreaterThanEqual(Integer minBedrooms);

	List<Property> findByFurnished(Boolean furnished);

	List<Property> findByStatusIgnoreCase(String status);

	List<Property> findAllByOrderByPriceDesc();

	Long countByCityIgnoreCase(String city);

	Long countByTypeIgnoreCase(String type);

	boolean existsByTitleIgnoreCase(String title);

	boolean existsByListedByIgnoreCase(String listedBy);

	boolean existsByCityIgnoreCaseAndTypeIgnoreCase(String city, String type);

	boolean existsByCityIgnoreCaseAndTypeIgnoreCaseAndBedrooms(String city, String type, Integer bedrooms);

	Long deleteByTitleIgnoreCase(String title);

	Long deleteByStatusIgnoreCase(String status);

	Long deleteByCityIgnoreCase(String city);

	List<Property> findByListedByIgnoreCase(String listedBy);

	List<Property> findByCityIgnoreCaseAndPriceBetweenAndFurnished(String city, Double minPrice, Double maxPrice,
			Boolean furnished);

	List<Property> findTop5ByOrderByPriceDesc();

	List<Property> findTop3ByOrderByCreatedAtDesc();

	List<Property> findByTitleContainingIgnoreCase(String title);
}
