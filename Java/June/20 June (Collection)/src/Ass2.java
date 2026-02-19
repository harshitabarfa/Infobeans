import java.util.*;
import java.util.List;

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		List<Integer> l = new ArrayList<Integer>();
//		l.add(1);
//		l.add(2);
//		l.add(3);
//		l.add(4);
		
		System.out.print("Enter number: ");
		while (true) 
		{
            Integer s = sc.nextInt();
            if (s==0) 
            {
                break;
            }
            l.add(s);
        }
		
		System.out.println(l);
		
		System.out.print("Even numbers: ");
		for(Integer o : l)
		{
			if(o%2==0)
			{
				System.out.print(o + " "); 
			}
		}
	}
}
