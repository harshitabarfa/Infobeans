package com.example.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
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
@Table(name = "fraudDetectionLogs")
public class FraudDetectionLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fraudId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private User user;

	@Enumerated(EnumType.STRING)
	private ItemType itemTypes;

	private Long itemId;

	@Column(columnDefinition = "TEXT")
	private String reason;

	private Float aiConfidence;

	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();

	public enum ItemType {
		LOST, FOUND
	}

	public Long getFraudId() {
		return fraudId;
	}

	public void setFraudId(Long fraudId) {
		this.fraudId = fraudId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ItemType getItemTypes() {
		return itemTypes;
	}

	public void setItemTypes(ItemType itemTypes) {
		this.itemTypes = itemTypes;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Float getAiConfidence() {
		return aiConfidence;
	}

	public void setAiConfidence(Float aiConfidence) {
		this.aiConfidence = aiConfidence;
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
