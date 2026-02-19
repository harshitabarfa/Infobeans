import java.util.*;

class Car
{
private String brand;
private String model;
private int year;
private double price;
private String color;

public Car(String brand, String model, int year, double price, String color)
{
this.brand = brand;
this.model = model;
this.year = year;
this.price = price;
this.color = color;
}

public String getBrand() 
{
return brand;
}

public String getModel() 
{
return model;
}

public int getYear() 
{
return year;
}

public double getPrice() 
{
return price;
}

public String getColor() 
{
return color;
}

public void setBrand(String brand) 
{
this.brand = brand;
}

public void setModel(String model) 
{
this.model = model;
}

public void setYear(int year) 
{
this.year = year;
}

public void setPrice(double price) 
{
this.price = price;
}

public void setColor(String color) 
{
this.color = color;
}

public void display() 
{
System.out.println("Brand: " + brand);
System.out.println("Model: " + model);
System.out.println("Year: " + year);
System.out.println("Price: $" + price);
System.out.println("Color: " + color);
}

}
class Ass4
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter how many cars you want? : ");
int num = sc.nextInt();
sc.nextLine();

Car c1[] = new Car[num];
System.out.println();

for(int i = 0; i<num; i++)
{
System.out.println("Enter details for car " + (i+1) + ":");

System.out.print("Brand: ");
String brand = sc.nextLine();

System.out.print("Model: ");
String model = sc.nextLine();

System.out.print("Year: ");
int year = sc.nextInt();
sc.nextLine();

System.out.print("Price: ");
double price = sc.nextDouble();
sc.nextLine();

System.out.print("Color: ");
String color = sc.nextLine();

c1[i] = new Car(brand, model, year, price, color);

System.out.println();
}

System.out.println("Display car details: ");
for(Car c2 : c1)
{
c2.display();
System.out.println();
}

Car mostExpensive = c1[0];

for (Car c2 : c1) 
{
if (c2.getPrice() > mostExpensive.getPrice()) 
{
mostExpensive = c2;
}
}

System.out.println("Most Expensive Car: ");
mostExpensive.display();

}
}





















