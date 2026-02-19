import java.util.*;

public class Ass8 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of students: ");
		int n = sc.nextInt();
		
		if (n < 1 || n > 10) 
		{
            System.out.println("Error: Number of seats must be between 1 and 10.");
            return;
        }
		
		TreeSet<Integer> t = new TreeSet<>();
		
		System.out.println("\nEnter elements: ");
		for(int i = 0; i<n; i++)
		{
			int n1 = sc.nextInt();
			t.add(n1);
		}
		
		System.out.println("\nUpdate list after removing elements: ");
		t.pollFirst();
		System.out.println(t);
	}
}
