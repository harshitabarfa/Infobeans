import java.util.*;
import java.util.stream.*;

class Student2 
{
    private String name;
    private int marks;

    public Student2(String name, int marks) 
    {
        this.name = name;
        this.marks = marks;
    }

    public String getName() 
    {
        return name;
    }

    public int getMarks() 
    {
        return marks;
    }

    @Override
    public String toString() 
    {
        return "Student [name=" + name + ", marks=" + marks + "]";
    }
}


public class Ass4 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter how many students: ");
        int n = Integer.parseInt(sc.nextLine());

        List<Student2> l = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            System.out.println("\nStudent " + (i + 1) + ":");

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = Integer.parseInt(sc.nextLine());

            Student2 s = new Student2(name, marks);
            l.add(s);
        }

        List<String> l1 = l.stream()
        		.filter(x -> x.getMarks() < 40)
        		.map(x -> x.getName())
        		.collect(Collectors.toList());
        
        System.out.println("\nStudents who failed: " + l1);
	}
}















