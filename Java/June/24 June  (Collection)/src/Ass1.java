import java.util.*;

public class Ass1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of ArrayList: ");
		int size = sc.nextInt();
		
		ArrayList<Integer> a = new ArrayList<Integer>(size);
		
		System.out.println("\nEnter elements of ArrayList: ");
		for(int i = 0; i < size; i++)
		{
			int a1 = sc.nextInt();
			a.add(a1);
		}
		System.out.print("\nArrayList Elements : " +a);
		
		System.out.print("\nSearching elements: ");
		int a2 = sc.nextInt();
		
		if(a.contains(a2))
		{
		System.out.println("Number " + a2 + " exits in the ArrayList");
		}
		else
		{
	    System.out.println("Number " + a2 + " not exits in the ArrayList");
		}
		
		System.out.print("\nWhat number you want to remove: ");
		int a3 = sc.nextInt();
		
		a.remove(Integer.valueOf(a3));
		System.out.println("\nAfter removing " + a3 + " ArrayList is: " + a);
		
		System.out.println("\nArrayList elements using normal for loop: ");
		for(int i = 0; i<a.size(); i++)
		{
			System.out.print(a.get(i) + " ");
		}
		
		System.out.println();
		System.out.println("\nArrayList elements using for-each loop: ");
		for(int a4 : a)
		{
			System.out.print(a4 + " ");
		}
		
		System.out.println();
		System.out.println("\nArrayList elements in descending order");
	    ArrayList<Integer> descList = new ArrayList<>(a);
	    
	    descList.sort(Collections.reverseOrder());
	    for (int a5 : descList) 
	    {
	    	System.out.print(a5 + " ");
	    }
	    
	    System.out.println();
	    int a6 = a.size();
	    System.out.println("\nNumber of elements in the ArrayList: " + a6);
	}
}