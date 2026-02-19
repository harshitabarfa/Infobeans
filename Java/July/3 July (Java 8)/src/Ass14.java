import java.util.*;

interface SumOfDigits
{
	public int sum(int n);
}

public class Ass14 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int n1 = sc.nextInt();
		
		SumOfDigits sd = n -> {
			int sum1 = 0;
			for(; n>0; n=n/10)
			{
				int d = n%10;
				sum1 += d;
			}
			return sum1;
		};
		System.out.println(sd.sum(n1));	
	}
}
