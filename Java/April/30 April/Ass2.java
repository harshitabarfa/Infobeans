class Car
{
String make;
String model;
int year;

Car()
{
this.make = "Unknown";
this.model = "Unknown";
this.year = 0;
}

Car(String make, String model, int year)
{
this.make = make;
this.model = model;
this.year = year;
}

public void displayDetails()
{
System.out.println("Car make: " + make);
System.out.println("Car model: " + model);
System.out.println("Car year: " + year);
System.out.println();
}
}

class Ass2
{
public static void main(String args[])
{
Car c = new Car();

System.out.println("Default Car Details:");

c.displayDetails();

Car c1 = new Car("Toyota", "Camry", 2021);

System.out.println("Custom Car Details:");

c1.displayDetails();

}
}
