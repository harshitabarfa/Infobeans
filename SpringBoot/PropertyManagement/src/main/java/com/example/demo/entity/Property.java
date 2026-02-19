package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String city;
	private String type;
	private Double price;
	private Integer bedrooms;
	private Boolean furnished;
	private String listedBy;
	private String status;
	private Instant createdAt = Instant.now();

	public Property() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Boolean getFurnished() {
		return furnished;
	}

	public void setFurnished(Boolean furnished) {
		this.furnished = furnished;
	}

	public String getListedBy() {
		return listedBy;
	}

	public void setListedBy(String listedBy) {
		this.listedBy = listedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Property(Long id, String title, String city, String type, Double price, Integer bedrooms, Boolean furnished,
			String listedBy, String status, Instant createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.city = city;
		this.type = type;
		this.price = price;
		this.bedrooms = bedrooms;
		this.furnished = furnished;
		this.listedBy = listedBy;
		this.status = status;
		this.createdAt = createdAt;
	}
}
