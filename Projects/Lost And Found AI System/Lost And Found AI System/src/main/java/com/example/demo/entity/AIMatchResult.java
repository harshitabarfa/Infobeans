package com.example.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aiMatchResults")
public class AIMatchResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matchId;
	private Float imageSimilarity;
	private Float textSimilarity;
	private Float locationScore;
	private Float overallScore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private LostItem lostItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private FoundItem foundItem;

	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDING;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();

	public enum Status {
		PENDING, CONFIRMED, REJECTED
	}

	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	public Float getImageSimilarity() {
		return imageSimilarity;
	}

	public void setImageSimilarity(Float imageSimilarity) {
		this.imageSimilarity = imageSimilarity;
	}

	public Float getTextSimilarity() {
		return textSimilarity;
	}

	public void setTextSimilarity(Float textSimilarity) {
		this.textSimilarity = textSimilarity;
	}

	public Float getLocationScore() {
		return locationScore;
	}

	public void setLocationScore(Float locationScore) {
		this.locationScore = locationScore;
	}

	public Float getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(Float overallScore) {
		this.overallScore = overallScore;
	}

	public LostItem getLostItem() {
		return lostItem;
	}

	public void setLostItem(LostItem lostItem) {
		this.lostItem = lostItem;
	}

	public FoundItem getFoundItem() {
		return foundItem;
	}

	public void setFoundItem(FoundItem foundItem) {
		this.foundItem = foundItem;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
