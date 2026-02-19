import java.util.Scanner;

public class MaxMin 
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
		
		int min = arr[0];
		for(int i = 0; i<arr.length; i++)
		{
			if(arr[i]<min)
			{
				min = arr[i];
			}
		}
		
		int max = arr[0];
		for(int i = 1; i<arr.length; i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
		System.out.println("Minimum number is: " +min);
		System.out.println("Maximum number is: " +max);
	}
}
