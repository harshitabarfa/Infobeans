import java.util.*;

public class Ass3 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Integer> m = new HashMap<>();
		
		int choice;
		do 
		{
			System.out.println("\n--- Student Marks Management ---");
			
	        System.out.println("\n1. Add Student Marks");
	        System.out.println("2. Remove Student");
	        System.out.println("3. Update Marks");
            System.out.println("4. Display All Students");
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
	        		System.out.print("Student already exists!");
	        	}
	        	else
	        	{
	        		System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    m.put(name, marks);
                    System.out.println("Marks added successfully!");
	        	}
	        	break;
	        	
	        case 2: 
	        	System.out.print("Enter name to remove: ");
	        	String nameToRemove = sc.nextLine();
	        	
	        	if(m.remove(nameToRemove) != null)
	        	{
	        		System.out.println("Student removed!");	        		
	        	}
	        	else
	        	{
	        		System.out.println("Student not found!");
	        	}
	        	break;
	        	
	        case 3:
	        	System.out.print("\nEnter student name to update: ");
	        	String nameToUpdate = sc.nextLine();
	        	
	        	if(m.containsKey(nameToUpdate))
	        	{
	        		System.out.print("Enter new marks: ");
	        		int marksToUpdate = sc.nextInt();
	        		m.put(nameToUpdate, marksToUpdate);
	        		
	        		System.out.println("Marks updated!");
	        		sc.nextLine();
	        	}
	        	else
	        	{
	        		System.out.println("Student not found!");
	        	}
	        	break;
	        	
	        case 4: 
	        	for(Map.Entry<String, Integer> entry: m.entrySet())
	        	{
	        		System.out.println(entry.getKey() + " = " + entry.getValue());
	        	}
	        	break;
	        	
	        case 5: 
	        	System.out.println("Exiting...");
	        
	        default:
	        	System.out.println("Invalid choice!");
	        }
		} while(choice != 5);
	}
}



















