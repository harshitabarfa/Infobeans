import java.util.*;
import java.util.function.Predicate;

class Product
{
	private int id;
	private String name;
	private double price;
	private double rating;
	
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
	
	public double getRating() 
	{
		return rating;
	}
	
	public void setRating(double rating) 
	{
		this.rating = rating;
	}

	public Product(int id, String name, double price, double rating) 
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(id, name, price, rating);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating);
	}

	@Override
	public String toString() 
	{
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", rating=" + rating + "]";
	}
}

public class Ass3 
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many product you want? ");
		int n = Integer.parseInt(sc.nextLine());
		
		ArrayList<Product> a = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nProduct " + (i+1) + " : " );
			
			System.out.print("Enter product id: ");
			int id = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter product name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter product price: ");
			double price = Double.parseDouble(sc.nextLine());
			
			System.out.print("Enter product rating: ");
			double rating = Double.parseDouble(sc.nextLine());
//            
//			if(rating < 0 || rating > 5.0) 
//			{
//				System.out.println("Please give rating between 0.4 and 0.5");
//				break;
//			}
			
			Product p = new Product(id, name, price, rating);
			a.add(p);
		}
		
		ArrayList<Product> a1 = new ArrayList<>();
		Predicate<Product> p2 = e -> e.getPrice() >= 500 && e.getRating() >= 4.0 && e.getRating() < 5.0;
		
		for(Product p4 : a)
		{
		 	if(p2.test(p4)) 
			{
				a1.add(p4);
			}
		}
		
		if(a1.size() == 0)
		{
			System.out.println("No product met the criteria!");
		}
		else
		{
		System.out.println("\nDisplay eligible products: ");
		}
		
		for(Product p4 : a1)
		{
			System.out.println(p4);
		}
	}
}
















