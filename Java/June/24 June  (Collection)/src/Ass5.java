import java.util.*;

class Library
{
	private String title;
	private String author;
	private int isbn;
	private double price;
	
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
	
	public int getIsbn() 
	{
		return isbn;
	}
	
	public void setIsbn(int isbn) 
	{
		this.isbn = isbn;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}

	public Library(String title, String author, int isbn, double price) 
	{
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}

	public String toString() 
	{
		return "Library [Book title = " + title + ", Author name = " + author + ", ISBN number = " + isbn + ", Book price = " + price + "]";
	}
}

public class Ass5 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		ArrayList<Library> l = new ArrayList<Library>();
		
		System.out.println();
		for (int i = 0; i < size; i++) 
		{
			System.out.println("Add book " + (i + 1) + ":");
			
			System.out.print("Enter Book title: ");
			String title = sc.nextLine();
			
			System.out.print("Enter author Name: ");
			String author = sc.nextLine();

			System.out.print("Enter ISBN Id: ");
			int isbn = Integer.parseInt(sc.nextLine());

			System.out.print("Enter book price: ");
			double price = Double.parseDouble(sc.nextLine());
			
			Library l1 = new Library(title, author, isbn, price);
			l.add(l1);

			System.out.println();
		}
		
		for(Library l2 : l)
		{
			System.out.println("Display All Books: " + l2);
		}
		
		System.out.print("\nSearch book by title name: ");
		String l3 = sc.nextLine();

		boolean found = false;
		for (Library book : l) 
		{
		    if (book.getTitle().equalsIgnoreCase(l3)) 
		    {
		        System.out.println("Title " + l3 + " exists in the ArrayList");
		        found = true;
		        break;
		    }
		}
		if (!found) 
		{
		    System.out.println("Title " + l3 + " does not exist in the ArrayList");
		}
		
		System.out.print("\nEnter ISBN to remove a book: ");
		int removeIsbn = Integer.parseInt(sc.nextLine());
		boolean removed = false;

		for (int i = 0; i < l.size(); i++) 
		{
			if (l.get(i).getIsbn() == removeIsbn) 
			{
				l.remove(i);
				System.out.println("Book with ISBN " + removeIsbn + " removed.");
				removed = true;
				break;
			}
		}
		if (!removed) {
			System.out.println("Book with ISBN " + removeIsbn + " not found.");
		}
		
		System.out.println("After removed ArrayList is: ");
		System.out.println(l);

		if (!l.isEmpty()) 
		{
			Library expensive = l.get(0);
			for (int i = 1; i < l.size(); i++) 
			{
				if (l.get(i).getPrice() > expensive.getPrice()) 
				{
					expensive = l.get(i);
				}
			}
			System.out.println("\nMost expensive book: " + expensive);
		} 
		else 
		{
			System.out.println("\nNo books available to find the most expensive one");
		}
	}
}
