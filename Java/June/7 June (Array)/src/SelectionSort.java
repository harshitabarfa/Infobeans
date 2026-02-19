import java.util.*;

public class SelectionSort 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter size: ");
    	int size = sc.nextInt();
    	
        int[] arr = new int[size];
        
        System.out.print("Enter array elements: ");
        for(int i = 0; i<arr.length; i++)
        {
        	arr[i] = sc.nextInt();
        }

        System.out.print("Sorted array: ");
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        for (int num : arr) 
        {
            System.out.print(num + " ");
        }
    }
}
