import java.util.*;

public class Ass4 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		
		int count = 0;
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
	
			if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
			{
				count++;
			}		
		}
		System.out.println("Number of consonants in given string is: " + count);
	}
}
