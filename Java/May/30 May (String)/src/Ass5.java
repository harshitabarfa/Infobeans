import java.util.*;

public class Ass5 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
	
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			{
				ch = (char)(ch-32);
			}	
			System.out.print(ch);
		}
	}
}
