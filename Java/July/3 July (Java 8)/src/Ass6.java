import java.util.*;

interface ConcatStrings
{
	public String concatenate(String s1, String s2);
}

public class Ass6 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		ConcatStrings c = (s1,s2) -> {
			return s1.concat(s2);
		};
		
		System.out.print("Enter first string: ");
		String s3 = sc.nextLine();
		
		System.out.print("Enter second string: ");
		String s4 = sc.nextLine();
		
		System.out.println(c.concatenate(s3, s4));
	}
}
