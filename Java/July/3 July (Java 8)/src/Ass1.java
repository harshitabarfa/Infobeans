import java.util.*;

interface CompareNumbers
{
	public void compare(int a, int b);
}

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
        System.out.print("Enter a: ");
        int a1 = sc.nextInt();
        
        System.out.print("Enter b: ");
        int b1 = sc.nextInt();
		
		CompareNumbers c = (a,b)->
		{
		if(a>b) {
			
		    System.out.println(a + " is greater!");
		}
		else if(a<b)
			System.out.println(b + " is lower!");	
		else
			System.out.println("Both are equal!");	
		};
		c.compare(a1, b1);
	}
}
