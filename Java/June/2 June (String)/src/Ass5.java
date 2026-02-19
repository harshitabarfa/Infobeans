import java.util.*;

public class Ass5 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int max = 0;
        char maxChar = ' ';
        
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') 
            {
                ch = (char)(ch + ('a' - 'A'));
            }
            
            int count = 0;

            for (int j = 0; j < s.length(); j++) 
            {
            	char chr = s.charAt(j);
            	
            	if (chr >= 'A' && chr <= 'Z') 
                {
                    chr = (char)(chr + ('a' - 'A'));
                }
            	
                if (chr == ch) {
                    count++;
                }
            }

            if (count > max) 
            {
                max = count;
                maxChar = ch;
            }
        }
        System.out.println(maxChar + " (" + max + " times)");
    }
}
