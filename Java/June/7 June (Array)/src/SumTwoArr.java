import java.util.*;

public class SumTwoArr 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first array size: ");
		int a = sc.nextInt();
		
		int A[] = new int[a];
		
		System.out.println("Enter first array elements:");
        for (int i = 0; i < a; i++) 
        {
            A[i] = sc.nextInt();
        }
		
		System.out.println("Enter second array size: ");
		int b = sc.nextInt();
		
		int B[] = new int[b];
		
		System.out.println("Enter second array elements:");
        for (int i = 0; i < b; i++) 
        {
            B[i] = sc.nextInt();
        }
        
        int size;
        if (a > b) 
        	size = a + 1;
        else 
        	size = b + 1;
        
        int[] sum = new int[size];

        int i = a - 1;
        int j = b - 1;
        int k = size - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) 
        {
            int digitSum = carry;
            if (i >= 0) 
            	digitSum += A[i--];
            if (j >= 0) 
            	digitSum += B[j--];
            
            sum[k--] = digitSum % 10;
            
            carry = digitSum / 10;
        }
        
        int start = 0;
        if (sum[0] == 0) 
        	start = 1;

        for (int x = start; x < size; x++) 
        {
            System.out.print(sum[x] + " ");
        }
	}
}
