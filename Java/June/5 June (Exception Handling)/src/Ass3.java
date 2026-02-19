import java.util.*;

public class Ass3 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			int result = n1/n2;
			System.out.println(result);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
	}
}
