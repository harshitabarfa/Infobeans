import java.util.Scanner;

public class Duplicates_6 
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
		
		int xorArr = 0;
        int xorRange = 0;

        for(int num : arr) 
        {
            xorArr ^= num;
        }
        
        for(int i = 1; i <= size-1; i++) 
        {
            xorRange ^= i;
        }

        int duplicate = xorArr ^ xorRange;

        System.out.println("Duplicate number is: " + duplicate);
	}
}