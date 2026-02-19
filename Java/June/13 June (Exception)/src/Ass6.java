import java.util.*;

public class Ass6 
{
	public static boolean isArmstrongNumber(int n) 
	{
        if (n < 0) 
        {
            throw new IllegalArgumentException("Input number must be non-negative");
        }

        int temp = n;
        int sum = 0;
        int digit;

        while (temp != 0) 
        {
            digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }
        return sum == n;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        try 
        {
        	System.out.print("Enter number: ");
            int num = sc.nextInt();

            if (isArmstrongNumber(num)) 
            {
                System.out.println(num + " is Armstrong number.");
            } 
            else 
            {
                System.out.println(num + " is not Armstrong number.");
            }

        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Error: Input number must be non-negative");
        }
        catch(InputMismatchException e)
        {
        	System.out.println("Error: Input must be a valid integer.");
        }
    }
}
