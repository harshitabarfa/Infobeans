import java.util.*;
import java.util.function.Predicate;

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine().toLowerCase();
		
		Predicate<String> p = e -> 
		{
			String rev = "";
			for(int i = 0; i<s.length(); i++)
			{
				char ch = s.charAt(i);
				rev = ch+rev;
			}
			
			if(rev.equals(e))
				return true;
			else
				return false;
		};
		
		System.out.println(p.test(s));
	}
}
