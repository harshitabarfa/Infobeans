import java.util.*;

public class K_rev 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        
        int arr[] = new int[size];
        
        System.out.println("Enter array elements: ");
        for(int i = 0; i<arr.length; i++)
        {
        	arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        
        int n = arr.length;

        k = k % n;

        int[] temp = new int[n];

        for (int i = 0; i < k; i++) 
        {
            temp[i] = arr[n - k + i];
        }

        for (int i = 0; i < n - k; i++) 
        {
            temp[k + i] = arr[i];
        }

        for (int i = 0; i < n; i++) 
        {
            arr[i] = temp[i];
        }

        for (int i = 0; i < n; i++) 
        {
            System.out.print(arr[i] + " ");
        }
	}
}
