package com.service;
import com.dao.*;
import com.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService 
{
	private BookDao dao = new BookDao();
	
	public void addBook(BookModel b) throws SQLException
	{
		dao.addBook(b);
	}
	
	public List<BookModel> getAllBook() throws SQLException
	{
		return dao.getAllBook();
	}
	
	public BookModel searchBook(int bookId) throws SQLException
	{
		if(bookId <= 0)
		{
			System.out.println("Book id must be greater than 0");
			return null;
		}
		return dao.searchBook(bookId);
	}
	
	public void updateBook(BookModel b) throws SQLException
	{
		dao.updateBook(b);
	}
	
	public void deleteBook(int bookId) throws SQLException
	{
		dao.deleteBook(bookId);
	}
	
	public List<BookModel> searchByAuthor(String author) throws SQLException
	{
		return dao.searchByAuthor(author);
	}
	
	public List<BookModel> getBooksInPriceRange(double min, double max) throws SQLException
	{
		return dao.getBooksInPriceRange(min, max);
	}
	
	public boolean increaseQuantity(int id, int add) throws SQLException
	{
		return dao.increaseQuantity(id, add);
	}
	
	public List<BookModel> sortByPrice() throws SQLException 
	{ 
		return dao.getBooksSortedByPrice(); 
	}
}










