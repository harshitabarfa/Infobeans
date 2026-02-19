package com.controller;
import com.service.*;
import com.dao.*;
import java.sql.*;
import java.util.*;
import com.model.*;

public class Book 
{
	public static void main(String args[]) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		BookService bs = new BookService();
		
		while(true)
		{
			System.out.println("\n--------Menu--------");
			System.out.println("1. Add a new book");
			System.out.println("2. View all books");
			System.out.println("3. Search book by id");
			System.out.println("4. Update book");
			System.out.println("5. Delete book");
			System.out.println("6. View books by author");
			System.out.println("7. View books in price range");
			System.out.println("8. Increase book quantity");
			System.out.println("9. Sort book by price(Ascending)");
			System.out.println("10. Exit");
			
			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
			case 1:
				System.out.print("\nEnter book id: ");
				int book_id = Integer.parseInt(sc.nextLine());
				
				System.out.print("Enter title: ");
				String title = sc.nextLine();
				
				System.out.print("Enter author: ");
				String author = sc.nextLine();
				
				System.out.print("Enter price: ");
				double price = Double.parseDouble(sc.nextLine());
				
				System.out.print("Enter quantity: ");
				int quantity = Integer.parseInt(sc.nextLine());
				
				BookModel b1 = new BookModel(book_id, title, author, price, quantity);
				bs.addBook(b1);
				
				System.out.println("Book added!");
				break;
		
			case 2:
				List<BookModel> l = bs.getAllBook();
				for(BookModel b : l)
				{
					System.out.println(b);
				}
				break;
				
			case 3:
				System.out.print("\nEnter book id to search: ");
				int sid = Integer.parseInt(sc.nextLine());
				
				BookModel book = bs.searchBook(sid);
				
				if (book != null) 
				{
			        System.out.println("\nBook Found:");
			        System.out.println("ID: " + book.getBook_id());
			        System.out.println("Title: " + book.getTitle());
			        System.out.println("Author: " + book.getAuthor());
			        System.out.println("Price: " + book.getPrice());
			        System.out.println("Quantity: " + book.getQuantity());
			    } 
				else 
				{
			        System.out.println("Book not found.");
			    }
			    break;
				
			case 4:
				System.out.print("\nEnter book id to update: ");
				int uid = Integer.parseInt(sc.nextLine());
				
				System.out.print("Enter new title: ");
				String utitle = sc.nextLine();
				
				System.out.print("Enter new author: ");
				String uauthor = sc.nextLine();
				
				System.out.print("Enter new price: ");
				double uprice = Double.parseDouble(sc.nextLine());
				
				System.out.print("Enter new quantity: ");
				int uquantity = Integer.parseInt(sc.nextLine());
	
				BookModel b2 = new BookModel(uid, utitle, uauthor, uprice, uquantity);
				bs.updateBook(b2);
				System.out.println("Book updated!");
				break;
				
			case 5:
				System.out.print("\nEnter book id to delete: ");
				int did = Integer.parseInt(sc.nextLine());
				
				bs.deleteBook(did);
				System.out.println("Book deleted!");
				break;
				
			case 6:
				System.out.print("\nEnter author name to search: ");
				String as = sc.nextLine();
				
				bs.searchByAuthor(as);
				
				List<BookModel> b4 = bs.searchByAuthor(as);

				if (b4.isEmpty()) 
				{
				    System.out.println("No books found for author: " + as);
				} 
				else 
				{
				    System.out.println("\nBooks by " + as + ":");
				    for (BookModel b : b4) 
				    {
				        System.out.println(b);
				    }
				}
				break;
				
			case 7:
			    System.out.print("\nEnter minimum price: ");
			    double minPrice = Double.parseDouble(sc.nextLine());

			    System.out.print("Enter maximum price: ");
			    double maxPrice = Double.parseDouble(sc.nextLine());

			    if (minPrice <= maxPrice && minPrice >= 0 && maxPrice >= 0) 
			    {
			        List<BookModel> list = bs.getBooksInPriceRange(minPrice, maxPrice);

			        if (list.isEmpty()) 
			        {
			            System.out.println("No books found in the given price range.");
			        } 
			        else 
			        {
			            for (BookModel b : list) 
			            {
			                System.out.println(b);
			            }
			        }
			    }
			    else
			    {
			    	System.out.println("Invalid price range.");
			    }
			    break;
			    
			case 8:
				System.out.print("\nEnter book ID to increase: ");
                int bid = Integer.parseInt(sc.nextLine());
                
                System.out.print("Additional quantity: ");
                int addQ = Integer.parseInt(sc.nextLine());
                
                boolean inc = bs.increaseQuantity(bid, addQ);
                System.out.println(inc ? "Quantity updated!" : "Update failed.");
                break;
                
			 case 9:
				 bs.sortByPrice().forEach(System.out::println);
				 break;
             
			 case 10:
				 System.out.println("Exiting..."); 
				 break;
             
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
















