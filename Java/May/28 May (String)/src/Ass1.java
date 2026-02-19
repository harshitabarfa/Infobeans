import java.util.*;

public class Ass1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter String: ");
		String s = sc.nextLine();
		
		char c[] = new char[s.length()];
		
		for(int i = 0; i<s.length(); i++)
		{
			c[i] = s.charAt(i);
		}
		
		boolean isPalindrome = true;
		
		int length = s.length();
		
		for(int i = 0; i<length/2; i++)
		{
			if(s.charAt(i) != s.charAt(length - 1 - i))
			{
				isPalindrome = false;
				break;
			}
		}
		
		if(isPalindrome)
		{
			System.out.println("Yes, it's palindrome.");
		}
		else
		{
			System.out.println("Not palindrome");
		}
	}

}
