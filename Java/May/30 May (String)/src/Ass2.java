import java.util.*;

public class Ass2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a passward: ");
		String s = sc.nextLine();

		if(s.length() < 8 || s.length() > 15)
		{
			System.out.println(s + " is an invalid password");
			return;
		}
		
		boolean upper = false;
		boolean lower = false;
		boolean digit = false;
		boolean special = false;
		
		 for (int i = 0; i < s.length(); i++)
		 {
	            char ch = s.charAt(i);
	            
	            if(ch>='A' && ch<='Z')
	            {
	            	upper = true;
	            }
	            else if(ch>='a' && ch<='z')
	            {
	            	lower = true;
	            }
	            else if(ch>='0' && ch<='9')
	            {
	            	digit = true;
	            }
	            else if(ch!=' ')
	            {
	            	special = true;
	            }
	            else
	            {
	            	System.out.println(s + " is an invalid password");
	            	return;
	            }
		 }
		 if(upper && lower && digit && special)
		 {
			 System.out.println(s + " is an valid password");
		 }
		 else
		 {
			 System.out.println(s + " is an invalid password");
		 }
	}
}
 

