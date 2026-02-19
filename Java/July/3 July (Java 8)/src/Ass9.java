import java.util.*;

interface MaxFinder
{
	public int findMax(int a, int b, int c);
}
public class Ass9 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		MaxFinder m = (a,b,c) ->
		{
			if(a>=b && a>=c)
			{
				return a;
			}
			else if(b>=a && b>=c)
			{
				return b;
			}
			else
			{
				return c;
			}
		};
		
		System.out.print("Enter first number: ");
		int x = sc.nextInt();
		
		System.out.print("Enter second number: ");
		int y = sc.nextInt();
		
		System.out.print("Enter third number: ");
		int z = sc.nextInt();
		
		System.out.println("\nMaximum number is: " + m.findMax(x, y, z));
	}
}
