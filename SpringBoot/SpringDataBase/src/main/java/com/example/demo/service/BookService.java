package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll(Sort.by("author"));
	}

	public Book getById(int id) {
		return bookRepository.findById(id).orElse(null);
	}

	public List<Book> getByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	public List<Book> getByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	public String deleteBook(int id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return "Book deleted successfully!";
		}
		return "Book not found!";
	}

	public boolean updateBook(int id, Book book) {
		if (bookRepository.existsById(id)) {
			Book b = bookRepository.findById(id).get();
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());

			bookRepository.save(b);
			return true;
		} else {
			return false;
		}
	}

	public long count() {
		return bookRepository.count();
	}

	public List<Book> findByTitleOptional(String title) {
		List<Book> allBooks = getAllBooks();
		if (title == null || title.isEmpty()) {
			return allBooks;
		}
		return bookRepository.findByTitleIgnoreCase(title);
	}

	public List<Book> findByTitleAndAuthor(String title, String author) {
		List<Book> allBooks = getAllBooks();
		List<Book> result = new ArrayList<>();

		for (Book book : allBooks) {
			boolean matchTitle = (title == null || title.isEmpty()) || book.getTitle().equalsIgnoreCase(title);
			boolean matchAuthor = (title == null || title.isEmpty()) || book.getAuthor().equalsIgnoreCase(author);

			if (matchTitle && matchAuthor) {
				result.add(book);
			}
		}
		return result;
	}
}
