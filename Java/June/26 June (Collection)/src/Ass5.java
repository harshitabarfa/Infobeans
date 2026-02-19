import java.util.*;

class Product
{
	private int p_Id;
	private String p_name;
	private double p_price;
	
	public Product(int p_Id, String p_name, double p_price) 
	{
		super();
		this.p_Id = p_Id;
		this.p_name = p_name;
		this.p_price = p_price;
	}

	public int getP_Id() 
	{
		return p_Id;
	}

	public String getP_name() 
	{
		return p_name;
	}

	public double getP_price() 
	{
		return p_price;
	}

	@Override
	public String toString() 
	{
		return "Product [p_Id=" + p_Id + ", p_name=" + p_name + ", p_price=" + p_price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(p_Id, p_name, p_price);
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
		return p_Id == other.p_Id && Objects.equals(p_name, other.p_name)
				&& Double.doubleToLongBits(p_price) == Double.doubleToLongBits(other.p_price);
	}
}

public class Ass5 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		Vector<Product> v = new Vector<Product>();
		
		System.out.print("Enter number of products: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nProduct " + (i+1) + ":");
			
			System.out.print("Enter product id: ");
			int p_Id = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter product name: ");
			String p_name = sc.nextLine();
			
			System.out.print("Enter product price: ");
			double p_price = Double.parseDouble(sc.nextLine());
			
			Product p = new Product(p_Id, p_name, p_price);
			
			if (v.contains(p)) 
			{
				System.out.println("\nDuplicate product! Not added.");
			} 
			else 
			{
				v.add(p);
			}
		}
		
		System.out.println("\nDisplay all products using for-each: ");
		for(Product p : v)
		{
			System.out.println(p);
		}
		
		System.out.println("\nDisplay all products using iterator: ");
		Iterator<Product> i = v.iterator();
		while(i.hasNext())
		{
			Product p = (Product)i.next();
			System.out.println(p);
		}
		
		System.out.println("\nDisplay all products using list iterator: ");
		ListIterator<Product> i1 = v.listIterator();
		while(i1.hasNext())
		{
			Product p1 = (Product)i1.next();
			System.out.println(p1);
		}
		
		System.out.println("\nDisplay all products using enumeration: ");
		Enumeration<Product> e = v.elements();
		while(e.hasMoreElements())
		{
			Product p2 = (Product)e.nextElement();
			System.out.println(p2);
		}
	}
}

















