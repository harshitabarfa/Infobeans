import java.util.*;

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Float> m = new HashMap<>();

        System.out.print("Number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) 
        {
            System.out.print("\nEnter studnet name " + i + ": ");
            String name = sc.nextLine();

            System.out.print("\nEnter marks of " + name + ": ");
            float marks = Float.parseFloat(sc.nextLine());

            m.put(name, marks);
        }
        
        System.out.print("\nEnter the name of the student to retrieve marks: ");
        String searchName = sc.nextLine();

        if (m.containsKey(searchName)) 
        {
            System.out.println(searchName + "'s marks: " + m.get(searchName));
        } 
        else 
        {
            System.out.println("Student not found.");
        }
	}
}
