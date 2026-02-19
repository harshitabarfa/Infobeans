package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Book;

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

	public Book getById(int id) {
		Iterator<Book> itr = list.iterator();

		while (itr.hasNext()) {
			Book book = itr.next();
			if (book.getId() == id) {
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
		return "Book not found";
	}

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

	public Book getBookByTitle(String title) {
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
}
