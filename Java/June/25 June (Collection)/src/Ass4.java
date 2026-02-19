import java.util.*;

class Passanger
{
	private int ticketNumber;
	private String name;
	private String source;
	private String destination;
	private String seatNumber;
	
	public int getTicketNumber() 
	{
		return ticketNumber;
	}
	
	public void setTicketNumber(int ticketNumber) 
	{
		this.ticketNumber = ticketNumber;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSource() 
	{
		return source;
	}
	
	public void setSource(String source) 
	{
		this.source = source;
	}
	
	public String getDestination() 
	{
		return destination;
	}
	
	public void setDestination(String destination) 
	{
		this.destination = destination;
	}
	
	public String getSeatNumber() 
	{
		return seatNumber;
	}
	
	public void setSeatNumber(String seatNumber) 
	{
		this.seatNumber = seatNumber;
	}

	public Passanger(int ticketNumber, String name, String source, String destination, String seatNumber) 
	{
		super();
		this.ticketNumber = ticketNumber;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.seatNumber = seatNumber;
	}

	public String toString() 
	{
		return "Passanger [ticketNumber=" + ticketNumber + ", name=" + name + ", source=" + source + ", destination="
				+ destination + ", seatNumber=" + seatNumber + "]";
	}
}

public class Ass4 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Passanger> l = new LinkedList<Passanger>();
		
		 System.out.print("Enter number of reservations: ");
	        int n = sc.nextInt();
	        sc.nextLine();

	        for (int i = 0; i < n; i++) 
	        {
	            System.out.println("\nEnter details for passenger " + (i + 1) + ":");

	            System.out.print("Ticket Number: ");
	            int ticketNumber = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Name: ");
	            String name = sc.nextLine();

	            System.out.print("Source: ");
	            String source = sc.nextLine();

	            System.out.print("Destination: ");
	            String destination = sc.nextLine();

	            System.out.print("Seat Number: ");
	            String seatNumber = sc.nextLine();

	            Passanger p = new Passanger(ticketNumber, name, source, destination, seatNumber);
	            l.add(p);
	        }
	        
	        System.out.println("\nDispaly all reserved tickets:");
	        for(Passanger p1 : l)
	        {
	        	System.out.println(p1);
	        }
	        
	        System.out.print("\nCancel a reservation by ticketNumber: ");
	        int cancel = Integer.parseInt(sc.nextLine());
	        
	        boolean found = false;
	        for(int i = 0; i<l.size(); i++)
	        {
	        	if(l.get(i).getTicketNumber() == cancel)
	        	{
	        		l.remove(i);
	        		System.out.println("Reservation cancelled successfully.");
	        	    found = true;
	        	}
	        }
	        if(!found)
	        {
	        	System.out.println("Ticket number not found.");
	        }
	        
	        System.out.println("\nUpdate list of reservations: ");
	        for(Passanger p1 : l)
	        {
	        	System.out.println(p1);
	        }
	}
}
