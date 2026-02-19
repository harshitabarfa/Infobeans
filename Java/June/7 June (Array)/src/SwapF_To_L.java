import java.util.*;

public class SwapF_To_L 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter array elements: ");
		int i;
		for(i = 0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int temp = arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = temp;
		
		System.out.println("Array after swapping first and last elements:");
		for(i = 0; i < arr.length; i++)
		{
		    System.out.print(arr[i] + " ");
		}
	}
}
