import java.util.*;

public class Ass4 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a sentence: ");
	    String s = sc.nextLine();

	    StringBuilder sb = new StringBuilder();       
	    StringBuilder result = new StringBuilder();    
	      
	    for (int i = s.length() - 1; i >= 0; i--) 
	    {
	    	char ch = s.charAt(i);

	        if (ch != ' ') 
	        {
	        	sb.insert(0, ch);
	        } 
	        else 
	        {
	            if (sb.length() > 0) 
	            {
	                result.append(sb);
	                sb.append(" ");
	                sb.setLength(0);
	                }
	            }
	        }

	        if (sb.length() > 0) 
	        {
	        	result.append(sb);
	        }
	        System.out.println("Reversed String: " + result.toString());

}
}