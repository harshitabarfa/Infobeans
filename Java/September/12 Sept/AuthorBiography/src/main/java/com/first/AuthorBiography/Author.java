package com.first.AuthorBiography;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "biographyId")
	private Biography biography;

	public Author() {
	}

	public Author(String name, String email, Biography biography) {
		this.name = name;
		this.email = email;
		this.biography = biography;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Biography getBiography() {
		return biography;
	}

	public void setBiography(Biography biography) {
		this.biography = biography;
	}

	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + ", biography=" + biography + "]";
	}
}
