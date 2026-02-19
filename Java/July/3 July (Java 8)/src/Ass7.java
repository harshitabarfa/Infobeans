import java.util.Scanner;

interface Square
{
	public int findSquare(int n);
}

class Ass7
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		Square s = n ->  n*n;
		
		System.out.print("Enter a number: ");
		int s1 = sc.nextInt();

		System.out.println(s.findSquare(s1));
	}
}
