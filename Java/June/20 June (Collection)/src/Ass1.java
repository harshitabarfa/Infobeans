import java.util.*;

public class Ass1 
{
	public static void main(String args[])
	{
		List<String> l = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
//		l.add("Hello");
//		l.add("Harshita");
//		l.add("Anshika");
//		l.add("Anamika");
		
		System.out.print("Enter string: ");
		while (true) 
		{
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("done")) 
            {
                break;
            }
            l.add(s);
        }
		
		System.out.println(l);
		
		for(String o : l)
		{
			if(o.toLowerCase().startsWith("a"))
			{
				System.out.println(o.toUpperCase()); 
			}
		}
	}
}
