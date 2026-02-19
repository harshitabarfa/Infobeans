import java.util.*;
import java.util.TreeSet;

class Student implements Comparable<Student>
{
	private int roll_no;
	private String name;
	private float marks;
	
	public int getRoll_no() 
	{
		return roll_no;
	}
	
	public void setRoll_no(int roll_no) 
	{
		this.roll_no = roll_no;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public float getMarks() 
	{
		return marks;
	}
	
	public void setMarks(float marks) 
	{
		this.marks = marks;
	}

	public Student(int roll_no, String name, float marks) 
	{
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.marks = marks;
	}
	
	@Override
	public String toString() 
	{
		return "Student [roll_no=" + roll_no + ", name=" + name + ", marks=" + marks + "]";
	}

	public int compareTo(Student o)
	{
		if(o.getMarks() > this.getMarks())
		{
			return -1;
		}
		else if(o.getMarks() < this.getMarks())
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}
}

public class Ass5
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Student> t = new TreeSet<>();
		
		System.out.print("Enter numbers of student: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nStudent " + (i+1) + " : ");
			
			System.out.print("\nEnter roll number: ");
			int roll_no = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter marks: ");
			float marks = Float.parseFloat(sc.nextLine());
			
			Student s = new Student(roll_no, name, marks);
			t.add(s);
		}
		
		System.out.println("\nDisplay list of all students: ");
		for(Student e : t)
		{
			System.out.println(e);
		}
	}
}
