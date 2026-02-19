class Product 
{
int productId;
String name;
double price;

public Product(int productId, String name, double price) 
{
this.productId = productId;
this.name = name;
this.price = price;
}

void display() 
{
System.out.println("Product ID: " + productId);
System.out.println("Name: " + name);
System.out.println("Price: " + price);
}
}

class Electronics extends Product 
{
int warranty; 

public Electronics(int productId, String name, double price, int warranty) 
{
super(productId, name, price);
this.warranty = warranty;
}

void display() 
{
super.display();
System.out.println("Warranty: " + warranty + " months");
}
}

class Clothing extends Product 
{
String size; 

public Clothing(int productId, String name, double price, String size) 
{
super(productId, name, price);
this.size = size;
}

void display() 
{
super.display();
System.out.println("Size: " + size);
}
}

class Grocery extends Product 
{

String expiryDate;

public Grocery(int productId, String name, double price, String expiryDate) 
{
super(productId, name, price);
this.expiryDate = expiryDate;
}

void display() 
{
super.display();
System.out.println("Expiry Date: " + expiryDate);
}
}

class Ass3 
{
public static void main(String[] args) 
{
Electronics electronic = new Electronics(101, "Smartphone", 699.99, 24);
        
Clothing clothing = new Clothing(102, "T-shirt", 19.99, "M");

Grocery grocery = new Grocery(103, "Milk", 2.99, "2025-12-31");

electronic.display();
System.out.println();
clothing.display();
System.out.println();
grocery.display();
}
}




