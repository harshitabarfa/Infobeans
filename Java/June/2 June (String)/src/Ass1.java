import java.util.*;

public class Ass1 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a sentence: ");
		String s = sc.nextLine();

		int count = 0;
		boolean word = false;
		
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			
			if(ch != ' ' && !word)
			{
				word = true;
				count++;
			}
			else if(ch == ' ')
			{
				word = false;
			}
		}
		System.out.println(count);
	}
}
