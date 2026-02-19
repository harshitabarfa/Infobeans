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
@Table(name = "lostItems")
public class LostItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lostId;
	private String itemName;
	private String description;
	private String category;
	private LocalDate lostDate;
	private LocalTime lostTime;
	private String location;

	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDING;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@OneToMany(mappedBy = "lostItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	private List<MediaFile> mediaFile;

	@OneToMany(mappedBy = "lostItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	private List<AIMatchResult> aiMatche;

	public enum Status {
		PENDING, MATCHED, FOUND
	}

	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();

	public Long getLostId() {
		return lostId;
	}

	public void setLostId(Long lostId) {
		this.lostId = lostId;
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

	public LocalDate getLostDate() {
		return lostDate;
	}

	public void setLostDate(LocalDate lostDate) {
		this.lostDate = lostDate;
	}

	public LocalTime getLostTime() {
		return lostTime;
	}

	public void setLostTime(LocalTime lostTime) {
		this.lostTime = lostTime;
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

	public List<AIMatchResult> getAiMatche() {
		return aiMatche;
	}

	public void setAiMatches(List<AIMatchResult> aiMatche) {
		this.aiMatche = aiMatche;
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
