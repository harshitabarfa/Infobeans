import java.util.*;

class Ticket
{
String movieName;
int seatNumber;
String showTime;
double price;

void setDetails(String name1, int seat1, String time1, double price1)
{
movieName = name1;
seatNumber = seat1;
showTime = time1;
price = price1;
}

void displayDeatils()
{
System.out.println("Movie name: "+movieName);
System.out.println("Seat number: "+seatNumber);
System.out.println("Show time: "+showTime);
System.out.println("Price: "+price);
}
}

class Ass1
{
public static void main(String args[])
{

Scanner sc = new Scanner(System.in);

Ticket t1 = new Ticket();
System.out.println("First Ticket: ");

System.out.print("Enter movie name: ");
String name = sc.nextLine();

System.out.print("Enter seat number: ");
int seat = sc.nextInt();
sc.nextLine(); 

System.out.print("Enter show time: ");
String time = sc.nextLine();

System.out.print("Enter ticket price: ");
double price = sc.nextDouble();

t1.setDetails(name, seat, time, price);
t1.displayDetails();
}
}