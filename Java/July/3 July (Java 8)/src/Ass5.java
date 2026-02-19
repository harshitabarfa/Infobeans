import java.util.Scanner;

interface PalindromeChecker
{
	public boolean isPalindrome(String str);
}

class Ass5
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s1 = sc.nextLine().toLowerCase();
		
		PalindromeChecker s = str -> {
			String rev = "";
			
			for(int i = 0; i<s1.length(); i++)
			{
				char ch = s1.charAt(i);
				rev = ch+rev;
			}
			if(rev.equals(s1))
				return true;
			else
				return false;
		};

		System.out.println(s.isPalindrome(s1));
	}
}
