import java.util.Scanner;

public class SecondMax
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
		
		int max = arr[0];
		for(int i = 1; i<arr.length; i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
		
		int min = arr[0];
		for(int i = 0; i<arr.length; i++)
		{
			if(arr[i]<min)
			{
				min = arr[i];
			}
		}
		
		int max2 = min;
		for(int i = 0; i<arr.length; i++) 
		{
			if(max != arr[i])
			{
				if(arr[i]>max2 && max != max2)
				{
					max2 = arr[i];
				}
			}
		}
		System.out.println("First maximum number is: " +max);
		System.out.println("Second maximum number is: " +max2);
	}
}
