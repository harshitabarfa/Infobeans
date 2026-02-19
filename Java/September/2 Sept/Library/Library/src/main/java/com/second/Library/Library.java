package com.second.Library;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "library")
public class Library {
	@Id
	int bookId;
	String title;
	String author;
	String genre;
	double price;
	int publishedYear;
	int quantity;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int bookId, String title, String author, String genre, double price, int publishedYear,
			int quantity) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.publishedYear = publishedYear;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Library [bookId=" + bookId + ", title=" + title + ", author=" + author + ", genre=" + genre + ", price="
				+ price + ", publishedYear=" + publishedYear + ", quantity=" + quantity + "]";
	}
}
