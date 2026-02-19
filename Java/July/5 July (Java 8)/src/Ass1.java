import java.util.*;
import java.util.function.Function;

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter kilometer: ");
		double km = sc.nextDouble();
		
		Function<Double, Double> f = x -> km * 0.621;
		
		System.out.print("Km convert into miles: " + f.apply(km));
	}
}
