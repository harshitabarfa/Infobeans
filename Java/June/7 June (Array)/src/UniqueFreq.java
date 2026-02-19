import java.util.*;

public class UniqueFreq 
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
		
		boolean[] counted = new boolean[size];
		int[] freq = new int[size];
		
	    for (int i = 0; i<size; i++) 
	    {
	    	if(counted[i])
	    		continue;
	    	
	    	int count = 1;
	    	for(int j = i+1; j<size; j++)
	    	{
	    		if(arr[i]==arr[j])
	    		{
	    			count++;
	    			counted[j] = true;
	    		}
	    	}
	    	freq[i] = count;
	    }
	    boolean unique = true;
	    boolean someSame = false;
	    
	    for(int i = 0; i<size; i++)
	    {
	    	if(freq[i]==0)
	    		continue;
	    	
	    	for(int j = i+1; j<size; j++)
	    	{
	    		if(freq[i]==freq[j] && freq[i] != 0)
	    		{
	    			unique = false;
	    			someSame = true;
	    			break;
	    		}
	    	}
	    	if(!unique)
	    		break;
	    }
	    if(unique)
	    {
	    	System.out.println("Frequinces are unique");
	    }
	    else if(someSame)
	    {
	    	System.out.println("Some frequinces are same");
	    }
	    else
	    {
	    	System.out.println("Frequinces are not unique");
	    }
	}
}
