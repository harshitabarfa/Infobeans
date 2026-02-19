import java.util.*;

class SortByName implements Comparator<Student>
{
	public int compare(Student p1, Student p2)
	{
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
}

class SortByRollNumber implements Comparator<Student>
{
	public int compare(Student p1, Student p2)
	{
		return Integer.compare(p1.getRollNumber(), p2.getRollNumber());
	}
}

class Student implements Comparable<Student>
{
	private int rollNumber;
	private String name;
	private int totalMarks;
	
	public int getRollNumber() 
	{
		return rollNumber;
	}
	
	public void setRollNumber(int rollNumber) 
	{
		this.rollNumber = rollNumber;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getTotalMarks() 
	{
		return totalMarks;
	}
	
	public void setTotalMarks(int totalMarks) 
	{
		this.totalMarks = totalMarks;
	}

	public String toString() 
	{
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", totalMarks=" + totalMarks + "]";
	}

	public Student(int rollNumber, String name, int totalMarks) 
	{
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.totalMarks = totalMarks;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(name, rollNumber, totalMarks);
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
		return Objects.equals(name, other.name) && rollNumber == other.rollNumber && totalMarks == other.totalMarks;
	}
	
	public int compareTo(Student s)
	{
		if(s.getTotalMarks() > this.getTotalMarks())
		{
			return +1;
		}
		else if(s.getTotalMarks() < this.getTotalMarks())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}

public class Ass3 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of product: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		ArrayList<Student> a = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nStudent " + (i+1) + " : ");
			
			System.out.print("\nEnter roll number: ");
			int rollNumber = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter total marks: ");
			int totalMarks = Integer.parseInt(sc.nextLine());
			
		    Student s = new Student(rollNumber, name, totalMarks);
			a.add(s);
		}
		
		Collections.sort(a);
		System.out.println("\nDefault sorting should be by totalMarks (higher marks first): ");
		for(Student e : a)
		{
			System.out.println(e);
		}
		
		Collections.sort(a, new SortByName());
		System.out.println("\nSorting by name: ");
		for(Student e : a)
		{
			System.out.println(e);
		}
		
		Collections.sort(a, new SortByRollNumber());
		System.out.println("\nSorting by roll number: ");
		for(Student e : a)
		{
			System.out.println(e);
		}	
	}
}
















