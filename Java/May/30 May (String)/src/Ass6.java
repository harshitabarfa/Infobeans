import java.util.*;

public class Ass6 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		
		String result = "";
        boolean newWord = true;
        
		for (int i = 0; i < s.length(); i++) 
		{
			char ch = s.charAt(i);
		 
			if (ch == ' ') {
                result += ch;
                newWord = true;
            } 
            else 
            {
                if (newWord) 
                {
                    if (ch >= 'a' && ch <= 'z') 
                    {
                        ch = (char) (ch - 32);
                    }
                    newWord = false;
                }
                result += ch;
            }
        }
        
        System.out.println(result);
	}
}
