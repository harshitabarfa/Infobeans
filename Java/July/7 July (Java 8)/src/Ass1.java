import java.util.*;
import java.util.stream.Collectors;

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number:");

		List<Integer> l = new ArrayList<>();

		while(true)
		{
		int n = sc.nextInt();
		if(n == 0)
		{
			break;
		}
		else
		{
			l.add(n);
		}
		}

		List<Integer> l1 = l.stream().filter(x-> x>0).collect(Collectors.toList());
		
		System.out.println(l1);
	}
}














