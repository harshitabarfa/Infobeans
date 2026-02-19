import java.util.*;

interface ReverseString
{
	public String reverse(String str);
}

public class Ass11 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		String s = sc.nextLine();
		
		ReverseString r = str ->
		{
			String rev = "";
			
			for(int i = 0; i<s.length(); i++)
			{
				char ch = s.charAt(i);
				rev = ch+rev;
			}
			return rev;
		};
		System.out.print(r.reverse(s));
	}
}
