package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "foundItems")
public class FoundItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long foundItemId;

	private String itemName;
	private String description;
	private String category;
	private LocalDate foundDate;
	private LocalTime foundTime;
	private String location;

	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDING;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@OneToMany(mappedBy = "foundItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	private List<MediaFile> mediaFile;

	@OneToMany(mappedBy = "foundItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	private List<AIMatchResult> aiMatches;

	public enum Status {
		PENDING, MATCHED, CLAIMED
	}

	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();

	public Long getFoundItemId() {
		return foundItemId;
	}

	public void setFoundItemId(Long foundItemId) {
		this.foundItemId = foundItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(LocalDate foundDate) {
		this.foundDate = foundDate;
	}
	
	public LocalTime getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(LocalTime foundTime) {
		this.foundTime = foundTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MediaFile> getMediaFile() {
		return mediaFile;
	}

	public void setMediaFile(List<MediaFile> mediaFile) {
		this.mediaFile = mediaFile;
	}

	public List<AIMatchResult> getAiMatches() {
		return aiMatches;
	}

	public void setAiMatches(List<AIMatchResult> aiMatches) {
		this.aiMatches = aiMatches;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
