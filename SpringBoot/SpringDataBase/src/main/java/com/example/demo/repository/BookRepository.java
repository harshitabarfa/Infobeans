package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findByTitle(String title);
	
	public List<Book> findByAuthor(String author);

	public List<Book> findByTitleIgnoreCase(String title);
}
