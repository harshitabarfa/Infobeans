package com.first.AuthorBiography;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Biography {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bioText;
	private String awards;

	public Biography() {
	}

	public Biography(String bioText, String awards) {
		this.bioText = bioText;
		this.awards = awards;
	}

	public int getId() {
		return id;
	}

	public String getBioText() {
		return bioText;
	}

	public void setBioText(String bioText) {
		this.bioText = bioText;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	@Override
	public String toString() {
		return "Biography [id=" + id + ", bioText=" + bioText + ", awards=" + awards + "]";
	}
}
