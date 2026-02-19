import java.util.*;

class Vehicle
{
String brand;
String model;
double price;
boolean isAvailable;

public Vehicle(String brand, String model, double price, boolean isAvailable)
{
this.brand = brand;
this.model = model;
this.price = price;
this.isAvailable = isAvailable;
}

public void display()
{
System.out.println("Brand: " +brand);
System.out.println("Model: " +model);
System.out.println("Price: " +price);
System.out.println("Vehicle is available or not: " + (isAvailable ? "Yes" : "No"));
}

}
class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number of vehicles: ");
int n = sc.nextInt();
sc.nextLine();

Vehicle v1[] = new Vehicle[n];

for(int i = 0; i<n; i++)
{
System.out.println();
System.out.println("Enter details for "+ (i+1) + " vehicle:");

System.out.print("Enter brand name: ");
String brand = sc.nextLine();

System.out.print("Enter model name: ");
String model = sc.nextLine();

System.out.print("Enter price: ");
double price = sc.nextDouble();

System.out.print("Available (true/false): ");
boolean isAvailable = sc.nextBoolean();
sc.nextLine();

v1[i] = new Vehicle(brand, model, price, isAvailable);


}

while (true) 
{
System.out.println();
System.out.println("Menu:");

System.out.println("1. Display all vehicles");
System.out.println("2. Display vehicles above a certain price");
System.out.println("3. Display vehicles by brand");
System.out.println("4. Display unavailable vehicles");
System.out.println("5. Exit");

System.out.println();

System.out.print("Enter your choice: ");

int choice = sc.nextInt();
sc.nextLine(); 

switch (choice) 
{
case 1:
System.out.println("All Vehicles:");
for (Vehicle v : v1) 
{
System.out.println();
v.display();
}
break;

case 2:
System.out.print("Enter the minimum price: ");
double minPrice = sc.nextDouble();

System.out.println();          System.out.println("Vehicles above " + minPrice + ":");

for (Vehicle v : v1) 
{
if (v.price > minPrice) 
{
v.display();
}
}
break;

case 3:
System.out.print("Enter the brand: ");
String brand = sc.nextLine();

System.out.println();                   System.out.println("Vehicles of brand " + brand + ":");

for (Vehicle v : v1) 
{
if (v.brand.equalsIgnoreCase(brand))
{
v.display();
}
}
break;

case 4:              System.out.println("Unavailable Vehicles: ");
System.out.println();
for (Vehicle v : v1) 
{
if (!v.isAvailable) 
{
v.display();
}
}
break;

case 5:                   System.out.println("Exiting...!!");
return;

default:                   System.out.println("Invalid choice. Please try again.");
}
System.out.println();
}

}
}







