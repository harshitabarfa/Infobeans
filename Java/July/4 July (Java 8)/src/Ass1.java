import java.util.*;
import java.util.function.Predicate;

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter e-mail: ");
		String eMail = sc.nextLine();
		
		Predicate<String> p = e -> 
		{
			if(e.contains("@") && e.endsWith(".com"))
			{
				return true;
			}
			else
			{
				return false;
			}
		};
		
		System.out.println(p.test(eMail));
	}
}
