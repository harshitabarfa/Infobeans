import java.util.*;

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> st = new Stack<>();
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine().toLowerCase();
		
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			st.push(ch);
		}
		
		String rev = "";
		for(int i = 0; i<s.length(); i++)
		{
			if(!st.isEmpty())
			{
				rev += st.pop();
			}
		}
		
		if(s.equals(rev))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
	}
}
