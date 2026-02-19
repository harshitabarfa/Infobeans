import java.util.*;
import java.util.stream.Collectors;

class Student1
{
	private String name;
	private int age;
	
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

	@Override
	public int hashCode() 
	{
		return Objects.hash(age, name);
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
		Student1 other = (Student1) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	public Student1(String name, int age) 
	{
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() 
	{
		return "University [name=" + name + ", age=" + age + "]";
	}
}

public class Ass3 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter how much students are: ");
		int n = Integer.parseInt(sc.nextLine());
		
		List<Student1> l = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nStudent " + (i+1) + ": ");
			
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter age: ");
			int age = Integer.parseInt(sc.nextLine());
			
			Student1 u = new Student1(name, age);
			l.add(u);
		}
		
		System.out.println("");
		boolean b = l.stream().anyMatch(x -> x.getAge() < 18);
	    
		System.out.println("Is any Student under 18 exists or not? " + b);
	}
}











