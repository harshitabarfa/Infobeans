package com.example.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "mediaFiles")
public class MediaFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mediaId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private LostItem lostItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private FoundItem foundItem;

	@Enumerated(EnumType.STRING)
	private ItemType itemTypes;

	private String fileUrl;

	@Enumerated(EnumType.STRING)
	private FileType fileType;

	@Column(columnDefinition = "TEXT")
	private String aiTags;

	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();

	public enum ItemType {
		LOST, FOUND
	}

	public enum FileType {
		IMAGE, VIDEO
	}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public String getAiTags() {
		return aiTags;
	}

	public void setAiTags(String aiTags) {
		this.aiTags = aiTags;
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
