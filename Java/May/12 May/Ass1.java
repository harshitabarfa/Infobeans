class Shape
{
public void calculateArea()
{
System.out.println("Area calculation not defined for Shape.");
}
}

class Circle extends Shape
{
private double radius;

Circle(double radius)
{
this.radius = radius;
}

public void calculateArea()
{
double area = Math.PI * radius * radius;

System.out.println("Area of circle: " +area);
}
}

class Rectangle extends Shape
{
private double length;
private double width;

Rectangle(double length, double width)
{
this.length = length;
this.width = width;
}

public void calculateArea()
{
double area = length * width;

System.out.println("Area of rectangle: " +area);
}
}

class Ass1
{
public static void main(String args[])
{
Shape s[] = new Shape[3];

s[0] = new Shape();
s[1] = new Circle(5);
s[2] = new Rectangle(4, 6);

for(Shape s1 : s)
{
s1.calculateArea();
}

}
}