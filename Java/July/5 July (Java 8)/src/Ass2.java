import java.util.*;
import java.util.function.Function;

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		
		Function<String, String> str = x -> {
			String rev = "";
			
			for(int i = 0; i<s.length(); i++)
			{
				char ch = s.charAt(i);
				rev = ch+rev;
			}
			return rev;
		};
		
		System.out.println(str.apply(s));
	}
}
