package com.info.LibraryBook;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;

	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	private List<Book> book = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int id, String name, String location, List<Book> book) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.book = book;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", location=" + location + ", book=" + book + "]";
	}
}
