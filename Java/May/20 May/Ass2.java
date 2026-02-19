import java.util.*;

interface Shape
{
public double calculateArea();
}

class Circle implements Shape
{
private double radius;

public Circle(double radius)
{
this.radius = radius;
}

public double calculateArea()
{
return Math.PI * radius * radius;
}
}

class Rectangle implements Shape
{
private double length;
private double width;

public Rectangle(double length, double width)
{
this.length = length;
this.width = width;
}

public double calculateArea()
{
return length * width;
}
}

class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Choose shape (circle/rectangle): ");
String st = sc.nextLine().toLowerCase();

Shape s;

if(st.equals("circle"))
{
System.out.print("Enter radius: ");
double radius = sc.nextDouble();
s = new Circle(radius);
}
else if(st.equals("rectangle"))
{
System.out.print("Enter length: ");
double length = sc.nextDouble();
System.out.print("Enter width: ");
double width = sc.nextDouble();
s = new Rectangle(length, width);
}
else
{
System.out.println("Invalid shape!");
return;
}
System.out.printf("Area: %.2f", s.calculateArea());
}
}
















