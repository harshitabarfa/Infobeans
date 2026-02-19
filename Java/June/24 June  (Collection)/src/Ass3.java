import java.util.*;

class Product 
{
	private int p_id;
	private String p_name;
	private double p_price;
	private String p_location;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public double getP_price() {
		return p_price;
	}

	public void setP_price(double p_price) {
		this.p_price = p_price;
	}

	public String getP_location() {
		return p_location;
	}

	public void setP_location(String p_location) {
		this.p_location = p_location;
	}

	public Product(int p_id, String p_name, double p_price, String p_location) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_location = p_location;
	}

	public String toString() {
		return "Product ID: " + p_id + ", Name: " + p_name + ", Price: " + p_price + ", Location: " + p_location;
	}
}

public class Ass3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

//		Product p1 = new Product(1, "Laptop", 750, "A1");
//		Product p2 = new Product(2, "Mouse", 150, "B2");
//		Product p3 = new Product(3, "Monitor", 1200, "C3");
//		Product p4 = new Product(4, "Keyboard", 400, "D4");
//		Product p5 = new Product(5, "Printer", 850, "E5");
//
		ArrayList<Product> p = new ArrayList<Product>();
//		p.add(p1);
//		p.add(p2);
//		p.add(p3);
//		p.add(p4);
//		p.add(p5);
		
		System.out.println("Enter size: ");
		int size = sc.nextInt();
		
		for (int i = 0; i < size; i++) 
		{
			System.out.println("Enter details for Product " + (i + 1) + ":");

			System.out.print("Enter Product ID: ");
			int p_id = sc.nextInt();

			sc.nextLine();

			System.out.print("Enter Product Name: ");
			String p_name = sc.nextLine();

			System.out.print("Enter Product Price: ");
			double p_price = sc.nextDouble();

			sc.nextLine();

			System.out.print("Enter Product Location: ");
			String p_location = sc.nextLine();
			
			Product p1 = new Product(p_id, p_name, p_price, p_location);
			p.add(p1);

			System.out.println();
		}

		System.out.println("Display all product from using for-each loop: ");
		System.out.println();
		for (Product p6 : p) {
			System.out.println(p6);
		}

		System.out.println("\nProducts with price above 500:");
		System.out.println();
		for (Product p6 : p) {
			if (p6.getP_price() > 500) {
				System.out.println(p6);
			}
		}
	}
}
