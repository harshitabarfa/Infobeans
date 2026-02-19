import java.util.*;

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		LinkedList<String> l = new LinkedList<String>();
		
		System.out.print("Enter the number of books: ");
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("Enter the title of book " + (i+1) + ": ");
			String title = sc.nextLine();
			
			l.add(title);
		}
		
		System.out.println("\nBooks in the inventory: ");
		
		for(String s : l)
		{
			System.out.println(s);
		}
	}
}
