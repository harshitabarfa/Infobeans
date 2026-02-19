import java.util.ArrayList;
import java.util.List;

public class Ass4
{
	public static void main(String args[])
	{
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(28);
		l.add(4);
		l.add(5);
		
		System.out.println(l);
		
		l.set(2, 3);
		System.out.println(l);
		
		l.remove(3);
		System.out.println(l);
	}
}
