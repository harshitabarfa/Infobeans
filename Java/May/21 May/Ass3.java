import java.util.*;

interface Ride
{
double calculateFare(double distance);
}

class BikeRide implements Ride 
{
public double calculateFare(double distance)
{
return distance * 5.0;
}
}

class CarRide implements Ride 
{
public double calculateFare(double distance)
{
return distance * 10.0;
}
}

class ShareRide implements Ride 
{
public double calculateFare(double distance)
{
return distance * 15.0;
}
}

class Ass3 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter ride type (bike/car/shared): ");
String type = sc.nextLine().toLowerCase();

System.out.print("Enter distance in km: ");
double distance = sc.nextDouble();

Ride r;

if (type.equals("bike")) 
{
r = new BikeRide();
} 
else if (type.equals("car")) 
{
r = new CarRide();
} 
else if (type.equals("shared")) 
{
r = new ShareRide();
} 
else 
{
System.out.println("Invalid ride type!");
return;
}

double fare = r.calculateFare(distance);
System.out.printf("Total fare: Rs.%.2f%n", fare);

}
}











