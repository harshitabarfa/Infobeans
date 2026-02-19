import java.util.*;

class Product implements Comparable<Product>
{
	private int id;
	private String name;
	private double price;
	
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

	public Product(int id, String name, double price) 
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() 
	{
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
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

public class Ass10 
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
			
			Product s = new Product(id, name, price);
			t.add(s);
		}
		
		System.out.println("\nProduct sorted by price(cheapest price): ");
		for(Product e : t)
		{
			System.out.println("\n" + e);
		}
	}
}













