import java.util.*;

class Book
{
	private int bookId;
	private String title;
	private String author;
	private String issuedToStudent;
	
	public int getBookId() 
	{
		return bookId;
	}
	
	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
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
	
	public String getIssuedToStudent() 
	{
		return issuedToStudent;
	}
	
	public void setIssuedToStudent(String issuedToStudent) 
	{
		this.issuedToStudent = issuedToStudent;
	}
	
	public Book(int bookId, String title, String author, String issuedToStudent) 
	{
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.issuedToStudent = issuedToStudent;
	}
	
	public String toString() 
	{
        return "BookId: " + bookId + ", Title: " + title + ", Author: " + author + ", Issued To: " + issuedToStudent;
    }
}

public class Ass3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Book> b = new LinkedList<Book>();
		
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		System.out.println();
		for (int i = 0; i < size; i++) 
		{
			System.out.println("Add book " + (i + 1) + ":");
			
			System.out.print("Enter book id: ");
			int bookId = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter book title: ");
			String title = sc.nextLine();
			
			System.out.print("Enter author Name: ");
			String author = sc.nextLine();

			System.out.print("Issued to (Student name): ");
			String issuedToStudent = sc.nextLine();
			
			Book b1 = new Book(bookId, title, author, issuedToStudent);
			b.add(b1);

			System.out.println();
		}
		
		System.out.println("\nBooks currently issued:");
		for(Book b2 : b)
		{
			System.out.println("Display All Books: " + b2);
		}
		
		System.out.print("\nEnter Book ID to return: ");
        int returnId = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i<b.size(); i++)
        {
        	if(b.get(i).getBookId() == returnId)
        	{
        		b.remove(i);
        		System.out.println("Book return successfully!");
        	}
        	else
        	{
        		System.out.println("Book id not found!");
        	}
        }
        
        System.out.print("\nEnter Book ID to search: ");
        int searchId = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i<b.size(); i++)
        {
        	if(b.get(i).getBookId() == searchId)
        	{
        		System.out.println("Book found: " + b);
        	}
        	else
        	{
        		System.out.println("Book not found");
        	}
        }
        
        System.out.println("\nBooks currently issued (after removal): ");
        for(Book b3: b)
        {
        	 System.out.println(b);
        }
	}
}
