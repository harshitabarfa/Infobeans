import java.util.ArrayList;
import java.util.List;

public class Ass3
{
	public static void main(String args[])
	{
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(28);
		l.add(3);
		l.add(4);
		l.add(5);
		
		System.out.println(l);
		
		for(Integer j : l)
		{
			int sum = 0;
			for(int i = 1; i<=j/2; i++)
			{
				if(j%i==0)
				{
				sum+=i;
				}
			}
			if(sum==j)
			{
				System.out.println("Perfect Number: " +j);
			}
		}
	}
}
