package com.model;

public class BookModel 
{
	private int book_id;
	private String title;
	private String author;
	private double price;
	private int quantity;
	
	public int getBook_id() 
	{
		return book_id;
	}
	
	public void setBook_id(int book_id) 
	{
		this.book_id = book_id;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getAuthor() 
	{
		return author;
	}
	
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	

	public BookModel() {}

	public BookModel(int book_id, String title, String author, double price, int quantity) 
	{
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
	}

	public String toString() 
	{
		return "Book-id: " + book_id + ", Title: " + title + ", Author: " + author + ", Price: " + price
				+ ", Quantity: " + quantity + "]";
	}
}
