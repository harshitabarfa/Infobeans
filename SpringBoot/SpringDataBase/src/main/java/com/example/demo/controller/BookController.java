package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/addBooks")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book book1 = bookService.addBook(book);

		if (book1 == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			return ResponseEntity.status(201).body(book1);
		}
	}

	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list1 = bookService.getAllBooks();

		if (list1.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list1);
		}
	}

	@GetMapping("get/{id}")
	public ResponseEntity<?> getBookById(@PathVariable int id) {
		Book book = bookService.getById(id);

		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
		} else {
			return ResponseEntity.status(200).body(book);
		}
	}

	@GetMapping("title/{title}")
	public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
		List<Book> book = bookService.getByTitle(title);

		if (book.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(book);
		}
	}

	@GetMapping("author/{author}")
	public ResponseEntity<?> getBookByAuthor(@PathVariable String author) {
		List<Book> book = bookService.getByAuthor(author);
		if (book.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(book);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id) {
		String b = bookService.deleteBook(id);

		if (b.equalsIgnoreCase("Book not found!")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
		} else {
			return ResponseEntity.status(200).body(b);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody Book book) {
		boolean b = bookService.updateBook(id, book);

		if (b) {
			return ResponseEntity.status(200).body("Book updated!");
		} else {
			return ResponseEntity.status(404).body("Book not found!");
		}
	}

	@GetMapping("/count")
	public ResponseEntity<Long> countBook() {
		long l = bookService.count();
		return ResponseEntity.status(200).body(l);
	}

	@GetMapping("/searchByTitle")
	public ResponseEntity<List<Book>> findByTitle(
			@RequestParam(value = "title", required = false, defaultValue = "") String title) {
		List<Book> result;
		if (title.isEmpty()) {
			result = bookService.getAllBooks();
		} else {
			result = bookService.findByTitleOptional(title);
		}

		if (result.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title,
			@RequestParam(required = false) String author) {
		List<Book> books = bookService.findByTitleAndAuthor(title, author);
		return ResponseEntity.status(200).body(books);
	}
}
