import java.util.Scanner;

public class Intersection_8
{
	public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size for A: ");
		int A = sc.nextInt();
		
		int arr[] = new int[A];
		
		System.out.println("Enter array elements(A): ");
		for(int i = 0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		System.out.print("Enter size for B: ");
		int B = sc.nextInt();
		
		int arr1[] = new int[B];
		
		System.out.println("Enter array elements(B): ");
		for(int i = 0; i<arr1.length; i++)
		{
			arr1[i] = sc.nextInt();
		}
		
		int i = 0, j = 0;
		
        System.out.println("Intersection of arrays:");
        while (i < A && j < B) 
        {
            if (arr[i] == arr1[j]) 
            {
                System.out.print(arr[i] + " ");
                i++;
                j++;
            } 
            else if (arr[i] < arr1[j]) 
            {
                i++;
            } 
            else 
            {
                j++;
            }
        }

	}
}
