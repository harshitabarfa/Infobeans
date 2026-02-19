import java.util.Scanner;

public class Ass5 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		
		String result = "";
		
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			
			if ((ch >= 'a' && ch <= 'z') || 
	            (ch >= 'A' && ch <= 'Z') || 
	            (ch >= '0' && ch <= '9')) 
	        {
	                result += ch;
	        }
		}	
		System.out.println(result);
	}
}
