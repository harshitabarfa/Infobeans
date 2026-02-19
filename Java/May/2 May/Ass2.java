import java.util.*;

class TicketBooking 
{
private String showName;
private int[] bookedSeats;

public TicketBooking(String showName, int[] bookedSeats) 
{
this.showName = showName;
this.bookedSeats = bookedSeats;
}

public void setShowName(String showName) {
this.showName = showName;
}

public String getShowName() 
{
return showName;
}

public void setBookedSeats(int[] bookedSeats) 
{
this.bookedSeats = bookedSeats;
}

public void display() 
{
System.out.print("Booked seats for " + showName + ": ");
for (int seat : bookedSeats) 
{
System.out.print(seat + " ");
}
System.out.println();
}

public int countBookedSeats() 
{
return bookedSeats.length;
}

public int highestSeatNumber() 
{
int max = bookedSeats[0];
for (int seat : bookedSeats) 
{
if (seat > max) 
{
max = seat;
}
}
return max;
}
}

class Ass2
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter movie show name: ");
String showName = sc.nextLine();

System.out.print("Enter number of seats to book: ");
int n = sc.nextInt();

int[] seats = new int[n];
System.out.println("Enter seat numbers:");

for (int i = 0; i < n; i++) 
{
System.out.print("Seat " + (i + 1) + ": ");
seats[i] = sc.nextInt();
}

TicketBooking booking = new TicketBooking(showName, seats);

System.out.println("Booking Details");
booking.display();

System.out.println("Total seats booked: " + booking.countBookedSeats());
        
System.out.println("Highest seat number: " + booking.highestSeatNumber());

}
}
