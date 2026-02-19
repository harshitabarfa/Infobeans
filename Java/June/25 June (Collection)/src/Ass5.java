import java.util.*;

public class Ass5 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		
		Stack<Character> st = new Stack<Character>();
		
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
		
		System.out.println("Reversed String: " + rev);
	}
}
