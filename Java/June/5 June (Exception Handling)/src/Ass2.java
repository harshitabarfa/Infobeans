import java.util.*;

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
            System.out.println("1. Divide two numbers");
            System.out.println("2. Exit");
            System.out.println();
            
            System.out.print("Enter your choice: ");
		try
		{
			choice = sc.nextInt();
			System.out.println();
			switch(choice)
			{
			case 1: 
				try
				{
					System.out.print("Enter first number: ");
			        int i = sc.nextInt();
			
			        System.out.print("Enter second number: ");
			        int j = sc.nextInt();
			
			        int k = i/j;
			        System.out.println("Result: " +k);
				}
				catch(ArithmeticException a)
		        {
					System.out.println("Cannot divide by zero");
		        }
		        catch (Exception e) 
		        {
                    System.out.println("Invalid input. Please enter numbers");
                    sc.nextLine();
                }
				break;
				
			case 2:
				System.out.println("Exiting...");
                break;
                
            default:
                System.out.println("Invalid choice");
            }
        } 
		catch (Exception e) 
		{
        System.out.println("Invalid input. Please enter number");
        sc.nextLine();
        choice = 0;
        }
		System.out.println();
        } 
		while (choice != 2);
	}
}
