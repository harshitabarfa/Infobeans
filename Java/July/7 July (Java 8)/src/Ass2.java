import java.util.*;
import java.util.stream.Collectors;

class Student
{
	int id;
	String name;
	int age;
	double marks;
	String department;

	public Student(int id, String name, int age, double marks, String department) 
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.department = department;
	}

	@Override
	public String toString() 
	{
		return id + ": " + name + ": " + age + ": " + marks + ": " + department;
	}
}

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter how much students are: ");
		int n = Integer.parseInt(sc.nextLine());
		
		List<Student> l = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nStudent " + (i+1) + ": ");
			
			System.out.print("Enter id: ");
			int id = Integer.parseInt(sc.nextLine());

			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter age: ");
			int age = Integer.parseInt(sc.nextLine());

			System.out.print("Enter marks: ");
			double marks = Double.parseDouble(sc.nextLine());

			System.out.print("Enter department: ");
			String department = sc.nextLine();
			
			Student s = new Student(id, name, age, marks, department);
			l.add(s);
		}
		
		System.out.println("\nDisplay students who have marks greater than 75:");
		List<Student> l1 = l.stream().filter(x-> x.marks > 75).collect(Collectors.toList());
		System.out.println(l1);
		
		
	}
}









