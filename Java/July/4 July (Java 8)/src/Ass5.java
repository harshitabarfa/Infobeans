import java.util.*;
import java.util.function.Predicate;

public class Ass5 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter passward: ");
		String s = sc.nextLine();	
		
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
		
		System.out.print("Input: " + s);
		if(p.test(s))
			System.out.println("\nOutput: Strong Passward!");
		else
			System.out.println("\nOutput: Weak Passward!");
	}
}









