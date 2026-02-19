package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/getAll")
	public List<Book> getAllBooks() {
		List<Book> list = bookService.getBooks();
		return list;
	}

	@PostMapping("/addBook")
	public Book bookAdd(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@GetMapping("/getBook/id/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}

	@GetMapping("/getBook/title/{title}")
	public Book getBookByName(@PathVariable String title) {
		return bookService.getBookByName(title);
	}

	@GetMapping("/removeBook/{id}")
	public String removeBook(@PathVariable("id") int id) {
		return this.bookService.removeBook(id);
	}

	/*
	 * @PutMapping("/updateBook/{id}") public boolean updateBook(@PathVariable int
	 * id, @RequestBody Book book) { return bookService.updateBook(id, book); }
	 */

	@PutMapping("/updateBook/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title,
			@RequestParam(required = false) String author) {
		List<Book> books = bookService.findByTitleAndAuthor(title, author);
		return ResponseEntity.status(200).body(books);
	}
}
