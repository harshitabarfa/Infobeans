import java.util.Scanner;

public class AllDuplicate_7 
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
		
        System.out.println("Duplicate number are:");
        
        for(int i =0; i<arr.length; i++)
        {
        	int val = arr[i];
        	if(val<0)
        	{
        		val = -val;
        	}
        	int index = val-1;
        	
        	if(arr[index] < 0)
        	{
        		System.out.println((index+1) + " ");
        	}
        	else
        	{
        		arr[index] = -arr[index];
        	}
        }
	}
}