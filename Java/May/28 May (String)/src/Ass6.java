import java.util.Scanner;

public class Ass6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter String: ");
		String s = sc.nextLine();
		
		char c[] = new char[s.length()];
		
		boolean spChar = false;
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			
			if(ch=='@' || ch=='#' || ch=='$')
			{
				spChar = true;
                break;
            }
		}
		if(spChar) {
            System.out.println("The string contains special characters ($, @, #).");
        } else {
            System.out.println("The string does NOT contain special characters ($, @, #).");
        }

	}
}
