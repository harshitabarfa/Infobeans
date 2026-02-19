import java.util.*;

interface Fibonacci
{
	public int generate(int n);
}

public class Ass13 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int n1 = sc.nextInt();
		
		Fibonacci f = n -> {
			int a = 0;
			int b = 1;
			
			for(int i = 0; i<n; i++)
			{
				 System.out.print(a + " ");
		         int c = a + b;
		         a = b;
		         b = c;
			}
			return n;
		};
		f.generate(n1);
	}
}
