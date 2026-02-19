import java.util.*;

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Integer> t = new TreeSet<>();
		
		System.out.print("Enter numbers of student: ");
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nEnter roll numbers " + (i+1) + ": ");
			int roll_no = sc.nextInt();
			
			if(t.contains(roll_no))
			{
				System.out.println("Roll number " + roll_no + " is a duplicate and will not be added");
			}
			else
			{
				t.add(roll_no);
			}
		}
		
		System.out.println("\nDisplay student roll numbers: ");
		for(Integer e : t)
		{
			System.out.println(e);
		}
	}
}
