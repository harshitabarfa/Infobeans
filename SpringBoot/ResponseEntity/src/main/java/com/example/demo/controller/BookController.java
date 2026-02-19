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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>> getBooks() {
		// return bookService.getBooks();

		List<Book> list = bookService.getBooks();
		if (list == null || list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list);
		}
	}

	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = bookService.addBook(book);
		return ResponseEntity.status(201).body(b);
	}

	/*
	 * @GetMapping("/getById/{id}") public ResponseEntity<Book>
	 * getById(@PathVariable("id") int id) { Book b = bookService.getById(id);
	 * 
	 * if (b == null) { // return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).build(); return
	 * ResponseEntity.status(404).build(); } else { return
	 * ResponseEntity.status(200).body(b); // return ResponseEntity.ok().body(b); //
	 * return ResponseEntity.status(HttpStatus.OK).body(b); } }
	 */

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		Book b = bookService.getById(id);

		if (b == null) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.status(404).body("Not found!");
		} else {
			return ResponseEntity.status(200).body(b);
			// return ResponseEntity.ok().body(b);
			// return ResponseEntity.status(HttpStatus.OK).body(b);
		}
	}

	@GetMapping("/getByTitle/{title}")
	public ResponseEntity<?> getByTitle(@PathVariable("title") String title) {
		Book b = bookService.getBookByTitle(title);

		if (b == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
		} else {
			return ResponseEntity.status(200).body(b);
		}
	}

	@DeleteMapping("/removeById/{id}")
	public ResponseEntity<String> removeBook(@PathVariable("id") int id) {
		String s = bookService.removeBook(id);

		if (s.equalsIgnoreCase("Book not found")) {
			return ResponseEntity.status(404).body(s);
		} else {
			return ResponseEntity.status(200).body(s);
		}
	}

	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
		Book b = bookService.updateBook(id, book);

		if (b != null) {
			return ResponseEntity.status(200).body(b);
		} else {
			return ResponseEntity.status(404).build();
		}
	}
}
