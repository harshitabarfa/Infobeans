class Vehicle 
{
public void Speed()
{
System.out.println("Speed varies for different vehicles.");
}
}

class Car extends Vehicle
{
public void Speed()
{
System.out.println("The car speed is 120 km/h.");
}
}

class Bike extends Vehicle
{
public void Speed()
{
System.out.println("The bike speed is 80 km/h.");
}
}

class Ass4
{
public static void displaySpeed(Vehicle v)
{
v.Speed();
}

public static void main(String args[])
{
Vehicle v = new Vehicle();
Vehicle v1 = new Car();
Vehicle v2 = new Bike();

displaySpeed(v);
displaySpeed(v1);
displaySpeed(v2);
}
}