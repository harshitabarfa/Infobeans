import java.util.*;

public class Ass7 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number of available seat: ");
		int n = sc.nextInt();
		
		if (n < 1 || n > 10) 
		{
            System.out.println("Error: Number of seats must be between 1 and 10.");
            return;
        }
		
		TreeSet<Integer> t = new TreeSet<>();
		
		System.out.println("\nEnter seat numbers: ");
		for(int i = 0; i<n; i++)
		{
			int n1 = sc.nextInt();
			if (n1 < 1 || n1 > 10) {
                System.out.println("Error: Seat number must be between 1 and 10.");
                return;
            }
			t.add(n1);
		}
		
		System.out.println("\nEnter seat numbers to search: ");
		int n2 = sc.nextInt();
		
		if(t.contains(n2))
		{
			System.out.println(n2 + " is present!");
		}
		else
		{
			System.out.println(n2 + " is not present!");
		}
	}
}
