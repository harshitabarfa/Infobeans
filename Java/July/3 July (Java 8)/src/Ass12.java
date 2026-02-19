import java.util.*;

interface VowelCounter
{
	public int count(String str);
}

public class Ass12 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine().toLowerCase();
		
		
		VowelCounter v = str -> {
			int count = 0;
			for(int i= 0; i<s.length(); i++)
			{
				char ch = s.charAt(i);
				
				if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
				{
					count++;
				}
			}
			return count;
		};
		System.out.println(v.count(s));
	}
}
