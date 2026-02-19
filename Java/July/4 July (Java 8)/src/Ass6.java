import java.util.*;
import java.util.function.Predicate;

public class Ass6 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<>();
		
		System.out.print("Enter passward: ");
		
		while(true)
		{
			String s = sc.nextLine();
			if(s.equalsIgnoreCase("done"))
				break;
			else
				a.add(s);
		}
		
		Predicate<String> p = e -> 
		{
			if(e.length() < 8)
				return false;
			
			boolean upper = false;
			boolean lower = false;
			boolean special = false;
			boolean digit = false;
			
			for(int i = 0; i<e.length(); i++)
			{
				char ch = e.charAt(i);
				
				if(ch >= 'A' && ch <= 'Z')
					upper = true;
				else if(ch >= 'a' && ch <= 'z')
					lower = true;
				else if(ch >= '0' && ch <= '9')
					digit = true;
				else
					special = true;
			}
			return upper && lower && digit && special;
		};
		
		for(String s1 : a)
		{
			System.out.print("\nInput: " + s1);
			if(p.test(s1))
				System.out.println("\nOutput: Strong Passward!");
			else
				System.out.println("\nOutput: Weak Passward!");
		}
	}
}









