import java.util.*;

public class Ass2 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		String s = sc.nextLine();
		
		char[] ch = s.toCharArray();

		int count = 0;
		
		for(int i = 0; i<ch.length; i++)
		{	
			count++;
		}
		System.out.println(count);
	}
}
