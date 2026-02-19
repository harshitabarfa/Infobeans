import java.util.Scanner;

interface Factorial
{
	public int calculate(int n);
}

class Ass3
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		Factorial s = n -> {
			int result = 1;
			for(int i = 2; i<=n; i++)
			
				result *= i;
				return result;
			
		};
		System.out.print("Enter a number: ");
		int s1 = sc.nextInt();

		System.out.println(s.calculate(s1));
	}
}
