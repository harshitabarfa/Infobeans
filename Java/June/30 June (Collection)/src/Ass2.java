import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class SortByProducts implements Comparator<Product>
{
	public int compare(Product p1, Product p2)
	{
		return Integer.compare(p2.getQuantity(), p1.getQuantity());
	}
}

class SortByProductName implements Comparator<Product>
{
	public int compare(Product p1, Product p2)
	{
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
}

class Product implements Comparable<Product>
{
	private int id;
	private String name;
	private double price;
	private int quantity;
	
	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}

	public Product(int id, String name, double price, int quantity) 
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String toString() 
	{
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	public int compareTo(Product p)
	{
		if(p.getPrice() > this.getPrice())
		{
			return -1;
		}
		else if(p.getPrice() < this.getPrice())
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}
}

public class Ass2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Product> t = new TreeSet<>();
		
		System.out.print("Enter number of product: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nProduct " + (i+1) + " : ");
			
			System.out.print("\nEnter product id: ");
			int id = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter product name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter product price: ");
			double price = Double.parseDouble(sc.nextLine());
			
			System.out.print("Enter product quantity: ");
			int quantity = Integer.parseInt(sc.nextLine());
			
			Product s = new Product(id, name, price, quantity);
			t.add(s);
		}
		
		System.out.println("\nProduct sorted by price(cheapest price): ");
		for(Product e : t)
		{
			System.out.println(e);
		}
		
		System.out.println("\nProduct sorted by quantity (Descending): ");
		for(Product e : t)
		{
			System.out.println(e);
		}
		
		System.out.println("\nProduct sorted by product name (Alphabetical): ");
		for(Product e : t)
		{
			System.out.println(e);
		}
	}
}













