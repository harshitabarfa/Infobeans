import java.util.*;

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> m = new HashMap<>();

        System.out.print("Number of countries: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) 
        {
            System.out.print("\nEnter the name of country " + i + ": ");
            String country = sc.nextLine();

            System.out.print("\nEnter the capital of " + country + ": ");
            String capital = sc.nextLine();

            m.put(country, capital);
        }
        
        System.out.println("\nCountry - Capital Map:");
        for (String country : m.keySet()) 
        {
            System.out.println(country + " = " + m.get(country));
        }
	}
}
