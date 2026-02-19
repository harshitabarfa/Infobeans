class TheaterBooking
{
public void bookTicket(String movieName, int numOfSeats)
{
boolean isPremium = false;
double totalPrice = price(numOfSeats, isPremium);

System.out.println("Movie : " +movieName);
System.out.println("Number of seats : " +numOfSeats+ " | Premium " + isPremium);
System.out.println("Total price: " +totalPrice);
}

public void bookTicket(String movieName, int numOfSeats, boolean isPremium)
{
double totalPrice = price(numOfSeats, isPremium);

System.out.println("Movie : " +movieName);
System.out.println("Number of seats : " +numOfSeats+ " | Premium " + isPremium);
System.out.println("Total price: " +totalPrice);
}

public void bookTicket(String movieName)
{
int numOfSeats = 2;
boolean isPremium = true;
double totalPrice = price(numOfSeats, isPremium);

System.out.println("Movie : " +movieName);
System.out.println("Number of seats : " +numOfSeats+ " | Premium " + isPremium);
System.out.println("Total price: " +totalPrice);
}

public double price(int numOfSeats, boolean isPremium) 
{
double rate = isPremium ? 250.0 : 150.0;
return rate * numOfSeats;
}
}

class Ass2
{
public static void main(String args[])
{
TheaterBooking t1 = new TheaterBooking();

t1.bookTicket("My fault",2);
System.out.println();
t1.bookTicket("365 days",2,true);
System.out.println();
t1.bookTicket("Fifty shades of grey");
}
}