import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ass4 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Double> m = new HashMap<>();
		
		int choice;
		do 
		{
			System.out.println("\n--- Employee Salary Management ---");
			
	        System.out.println("\n1. Add Employee Salary");
	        System.out.println("2. Remove Employee");
	        System.out.println("3. Update Salary");
            System.out.println("4. Display All Employees");
	        System.out.println("5. Exit");
	        
	        System.out.print("\nChoose an option: ");
	            
	        while (!sc.hasNextInt()) 
	        {
	        	System.out.print("Please enter a valid option (1-5): ");
	            sc.next();
	        }
	        
	        choice = sc.nextInt();
	        sc.nextLine();
	        
	        switch(choice)
	        {
	        case 1: 
	        	System.out.print("Enter name: ");
	        	String name = sc.nextLine();
	        	
	        	if(m.containsKey(name))
	        	{
	        		System.out.print("Employee already exists!");
	        	}
	        	else
	        	{
	        		System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    m.put(name, salary);
                    System.out.println("Salary added successfully!");
	        	}
	        	break;
	        	
	        case 2: 
	        	System.out.print("Enter name to remove: ");
	        	String nameToRemove = sc.nextLine();
	        	
	        	if(m.remove(nameToRemove) != null)
	        	{
	        		System.out.println("Employee removed!");	        		
	        	}
	        	else
	        	{
	        		System.out.println("Employee not found!");
	        	}
	        	break;
	        	
	        case 3:
	        	System.out.print("\nEnter Employee name to update: ");
	        	String nameToUpdate = sc.nextLine();
	        	
	        	if(m.containsKey(nameToUpdate))
	        	{
	        		System.out.print("Enter new salary: ");
	        		double salaryToUpdate = sc.nextDouble();
	        		m.put(nameToUpdate, salaryToUpdate);
	        		
	        		System.out.println("Salary updated!");
	        		sc.nextLine();
	        	}
	        	else
	        	{
	        		System.out.println("Employee not found!");
	        	}
	        	break;
	        	
	        case 4: 
	        	for(Map.Entry<String, Double> entry: m.entrySet())
	        	{
	        		System.out.println(entry.getKey() + " = " + entry.getValue());
	        	}
	        	break;
	        	
	        case 5: 
	        	System.out.println("Exiting...");
	        	break;
	        
	        default:
	        	System.out.println("Invalid choice!");
	        }
		} while(choice != 5);
	}
}



















