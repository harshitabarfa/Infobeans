import java.util.*;

public class Ass5
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		List<String> l = new ArrayList<String>();
		
		System.out.print("Enter multiple string: ");
		while (true) 
		{
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("done")) 
            {
                break;
            }
            l.add(s);
        }
		
		System.out.print("Enter search string: ");
		String s1 = sc.nextLine();
		
		 boolean found = false;
	     for (int i = 0; i < l.size(); i++) 
	     {
	    	 if (l.get(i).equals(s1)) 
	         {
	    		 System.out.println("Found at position: " + i);
	             found = true;
	         }
	     }

	     if (!found) 
	     {
	    	 System.out.println("String not found in the list.");
	     }
	}
}
