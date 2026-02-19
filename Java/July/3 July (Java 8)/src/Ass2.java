import java.util.*;

interface StringLength 
{
	public int getLength(String str);
}

class Ass2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		StringLength s = str -> str.replace(" ", "").length();
		
		System.out.print("Enter a string: ");
		String s1 = sc.nextLine();
		
		System.out.println(s.getLength(s1));
	}
}
