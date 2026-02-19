import java.util.*;
import java.util.stream.Collectors;

class Student
{
	private String name;
	private double marks;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public double getMarks() 
	{
		return marks;
	}
	
	public void setMarks(double marks) 
	{
		this.marks = marks;
	}

	public Student(String name, double marks) 
	{
		super();
		this.name = name;
		this.marks = marks;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(marks, name);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(marks) == Double.doubleToLongBits(other.marks)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
}

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter how many student: ");
		int n = Integer.parseInt(sc.nextLine());
		
		List<Student> l = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nStudent " + (i+1) + ": ");
			
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter marks: ");
			double marks = Double.parseDouble(sc.nextLine());
			
			Student s = new Student(name, marks);
			l.add(s);
		}
		
		List<Student> l1 = l.stream().sorted((i1,i2) -> {
			if(i1.getMarks()<i2.getMarks())
				return +1;
			else if(i1.getMarks()>i2.getMarks())
				return -1;
			else
				return 0;
		}).collect(Collectors.toList());
		
		System.out.println("\nDisplay the sorted list: ");
		System.out.println(l1);
	}
}














