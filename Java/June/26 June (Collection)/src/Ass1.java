import java.util.*;

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		
		System.out.println("\nEnter " + size + " roll numbers:");
		for(int i = 0; i<size; i++)
		{
			int roll = sc.nextInt();
			
			if(t.contains(roll))
			{
				System.out.println("Roll number " + roll + " is a duplicate and will not be added");
			}
			else
			{
				t.add(roll);
			}
		}
		
		System.out.println("\nUnique roll numbers in ascending order:");
        for (int roll : t) 
        {
            System.out.println(roll);
        }
	}
}
