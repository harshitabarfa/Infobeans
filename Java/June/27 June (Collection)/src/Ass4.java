import java.util.*;
import java.util.TreeSet;

class ReverseSorting implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		return -s1.compareTo(s2);
	}
}

public class Ass4
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<String> t = new TreeSet<>(new ReverseSorting());
		
		System.out.print("Enter numbers of city: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nEnter city " + (i+1) + " : ");
			String city = sc.nextLine();
			
			t.add(city);
		}
		
		System.out.println("\nDisplay list of all unique city: ");
		for(String e : t)
		{
			System.out.println(e);
		}
	}
}
