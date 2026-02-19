import java.util.*;

interface ToUpperCase
{
	public String convert(String str);
}

public class Ass8 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		ToUpperCase c = str -> str.toUpperCase();
		
		System.out.print("Enter a string: ");
		String c1 = sc.nextLine();
		
		System.out.println(c.convert(c1));
	}
}
