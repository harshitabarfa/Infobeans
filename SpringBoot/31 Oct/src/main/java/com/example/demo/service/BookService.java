package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Product;

@Service
public class BookService {
	public static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(101, "Java coding", "James"));
		list.add(new Book(102, "Life", "Harshita"));
		list.add(new Book(103, "Mountain", "Shraddha"));
	}

	public List<Book> getBooks() {
		return list;
	}

	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

	public Book getBookById(int id) {
		Iterator<Book> itr = list.iterator();

		Book book = null;
		while (itr.hasNext()) {
			book = itr.next();
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	public Book getBookByName(String title) {
		Iterator<Book> itr = list.iterator();

		Book book = null;
		while (itr.hasNext()) {
			book = itr.next();
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}

	public String removeBook(int id) {
		Iterator<Book> itr = list.iterator();

		Book book = null;
		while (itr.hasNext()) {
			book = itr.next();
			if (book.getId() == id) {
				itr.remove();
				return "Book deleted successfully!";
			}
		}
		return null;
	}

	/*
	 * public boolean updateBook(int id, Book book) { Iterator<Book> itr =
	 * list.iterator();
	 * 
	 * while (itr.hasNext()) { Book b = (Book) itr.next(); if (b.getId() == id) {
	 * b.setTitle(book.getTitle()); b.setAuthor(book.getAuthor()); return true; } }
	 * return false; }
	 */

	public Book updateBook(int id, Book book) {
		Iterator<Book> itr = list.iterator();

		while (itr.hasNext()) {
			Book b = (Book) itr.next();
			if (b.getId() == id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				return book;
			}
		}
		return null;
	}

	public List<Book> findByTitleAndAuthor(String title, String author) {
		List<Book> allBooks = getBooks();
		List<Book> result = new ArrayList<>();

		for (Book book : allBooks) {
			boolean matchTitle = (title == null || title.isEmpty()) || book.getTitle().equalsIgnoreCase(title);
			boolean matchAuthor = (author == null || author.isEmpty()) || book.getAuthor().equalsIgnoreCase(author);

			if (matchTitle && matchAuthor) {
				result.add(book);
			}
		}
		return result;
	}
}
