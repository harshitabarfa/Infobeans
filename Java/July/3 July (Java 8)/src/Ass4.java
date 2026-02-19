import java.util.Scanner;

interface Power
{
	public int findPower(int base, int exponent);
}

class Ass4
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		Power s = (base, exponent) -> (int)Math.pow(base, exponent);
		
		System.out.print("Enter base: ");
		int s1 = sc.nextInt();
		
		System.out.print("Enter exponent: ");
		int s2 = sc.nextInt();

		System.out.println(s.findPower(s1,s2));
	}
}
