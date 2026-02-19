import java.util.*;

public class CheckNum 
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
		
		/* System.out.print("Enter number: ");
		int n = sc.nextInt();
		
		boolean linearFound = false;
		
	    for (int i = 0; i < arr.length; i++) 
	    {
	    	if (arr[i] == n) 
	    	{
	    		linearFound = true;
	            break;
	        }
	    }
	    
	    if (linearFound) 
	    {
            System.out.println("Linear Search: Number found");
        } 
	    else 
	    {
            System.out.println("Linear Search: Number not found");
        } */
	    
	    int start = 0;
	    int end = arr.length-1;
	    boolean binaryFound = false;
	    
	    for (int i = 0; i < size - 1; i++) 
	    {
            for (int j = 0; j < size - 1 - i; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
	    
	    System.out.println("Sorted array:");
	    for(int num : arr)
	    {
	    	System.out.print(num + " ");
	    }
	    System.out.println();
	    
	    System.out.print("Enter number: ");
		int n = sc.nextInt();
	    
	    while(start<=end)
	    {
	    	int mid = (start+end)/2;
	    	
	    	if(arr[mid] == n)
	    	{
	    		binaryFound = true;
	    		break;
	    	}
	    	else if(arr[mid] < n)
	    	{
	    		start = mid+1;
	    	}
	    	else
	    	{
	    		start = mid-1;
	    	}
	    }
	    
	    if (binaryFound) 
	    {
            System.out.println("Binary Search: Number found");
        } 
	    else 
	    {
            System.out.println("Binary Search: Number not found");
	    }
	}
}
