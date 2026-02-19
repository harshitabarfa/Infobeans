import java.util.*;
import java.util.TreeSet;

class MyPriceSorting implements Comparator<Double>
{
	public int compare(Double i1, Double i2)
	{
		return -i1.compareTo(i2);
	}
}

public class Ass2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Double> t = new TreeSet<>(new MyPriceSorting());
		
		System.out.print("Enter numbers of product price: ");
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nEnter product number " + (i+1) + " price : ");
			double prices = sc.nextDouble();
			
			t.add(prices);
		}
		
		System.out.println("\nDisplay product prices: ");
		for(Double e : t)
		{
			System.out.println(e);
		}
	}
}
