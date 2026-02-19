import java.util.*;

public class UniqueElement 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter array elements: ");
		for(int i = 0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		 int unique = 0;
	     for (int num : arr) 
	     {
	    	 unique ^= num;
	     }
	     System.out.println("The unique element is: " + unique);
	}
}
