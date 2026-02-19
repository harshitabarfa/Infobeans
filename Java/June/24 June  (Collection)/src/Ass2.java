import java.util.*;

class Student 
{
	private String name;
	private int age;
	private float marks;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public float getMarks() 
	{
		return marks;
	}

	public void setMarks(float marks) 
	{
		this.marks = marks;
	}

	public Student(String name, int age, float marks) 
	{
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	
	void display()
	{
		System.out.println("Name: " + name + ", Age: " + age + ", Marks: " + marks);
	}
}

public class Ass2 
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Student> l = new ArrayList<Student>();
		
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < size; i++) 
		{
			System.out.println();
			System.out.println("Student " + (i+1) + " details: ");
			
			System.out.print("Enter student name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter student age: ");
			int age = sc.nextInt();
			
			System.out.print("Enter student mark: ");
			float mark = sc.nextFloat();
			sc.nextLine();
			
			l.add(new Student(name, age, mark));
		}
		System.out.println();
		System.out.println("All student details: ");
		System.out.println();
		for(Student s : l)
		{
			s.display();
		}
	}
}
