import java.util.*;

interface EvenOddChecker 
{
	public void check(int n);
}

public class Ass10 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		EvenOddChecker e = n -> 
		{
			if(n%2==0)
				 System.out.println("Even");
			else
				System.out.println("Odd");
		};
		System.out.print("Enter a number: ");
		int e1 = sc.nextInt();
		
		e.check(e1);
	}
}
