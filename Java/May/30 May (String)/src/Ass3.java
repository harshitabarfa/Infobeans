import java.util.*;
public class Ass3 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Venue name and city: ");
		String s = sc.nextLine();
		
		String[] venueDetails = s.split(",");
		
		String venueName = venueDetails[0];
        String city = venueDetails[1];
        
        System.out.println("Venue Details:");
        System.out.println("Venue Name: " + venueName);
        System.out.println("City Name: " + city);
	}

}
