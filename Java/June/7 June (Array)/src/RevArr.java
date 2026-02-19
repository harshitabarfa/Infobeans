import java.util.*;

public class RevArr 
{
	public static void main(String args[])
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
		
		System.out.println("Before reverse array elements: ");
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;	
		}
		
		System.out.println("After reverse array elements: ");
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
