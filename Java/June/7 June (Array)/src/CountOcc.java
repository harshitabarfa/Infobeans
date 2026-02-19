import java.util.*;

public class CountOcc 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int x = sc.nextInt();

        int first = -1;
        int last = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) 
        {
            int mid = (low + high) / 2;

            if (arr[mid] == x) 
            {
                first = mid;
                high = mid - 1;
            } 
            else if (arr[mid] < x) 
            {
                low = mid + 1;
            } 
            else 
            {
                high = mid - 1;
            }
        }

        low = 0;
        high = n - 1;

        while (low <= high) 
        {
            int mid = (low + high) / 2;

            if (arr[mid] == x) 
            {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < x) 
            {
                low = mid + 1;
            } 
            else 
            {
                high = mid - 1;
            }
        }

        if (first == -1) 
        {
            System.out.println("Element not found.");
        } 
        else 
        {
            int count = last - first + 1;
            System.out.println("Total number of occurrences is: " + count);
        }
    }
}
