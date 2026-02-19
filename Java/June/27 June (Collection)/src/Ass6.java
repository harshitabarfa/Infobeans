import java.util.*;
import java.util.TreeSet;

class MyNameSorting implements Comparator<Student1>
{
	public int compare(Student1 i1, Student1 i2)
	{
		return i1.getName().compareTo(i2.getName());
	}
}

class Student1 implements Comparable<Student1>
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

	public Student1(int roll_no, String name, float marks) 
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

	public int compareTo(Student1 o)
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

public class Ass6
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Student1> t = new TreeSet<>();
		TreeSet<Student1> t1 = new TreeSet<>(new MyNameSorting());
		
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
			
			Student1 s = new Student1(roll_no, name, marks);
			t.add(s);
			t1.add(s);
		}
		
		System.out.println("\nDisplay list of all students (marks based): ");
		for(Student1 e : t)
		{
			System.out.println(e);
		}
		
		System.out.println("\nDisplay list of all students (name based): ");
		for(Student1 e1 : t1)
		{
			System.out.println(e1);
		}
	}
}
