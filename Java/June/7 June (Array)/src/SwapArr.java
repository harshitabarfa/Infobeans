import java.util.*;

public class SwapArr 
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
		
		System.out.println("Before swap array elements: ");
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
        System.out.println();
        
		for(int i = 0; i<size; i+=2)
		{
			if(i+1 < size) 
			{
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		    }
		}
		
		System.out.println("After swap array elements: ");
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
