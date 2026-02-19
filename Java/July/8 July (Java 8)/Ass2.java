import java.util.*;
import java.util.stream.Collectors;

class University
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
		University other = (University) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	public University(String name, int age) 
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

public class Ass2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter how much students are: ");
		int n = Integer.parseInt(sc.nextLine());
		
		List<University> l = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nStudent " + (i+1) + ": ");
			
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter age: ");
			int age = Integer.parseInt(sc.nextLine());
			
			University u = new University(name, age);
			l.add(u);
		}
		
		List<Integer> l2 = new ArrayList<>();
		for (University u : l) 
		{
			l2.add(u.getAge());
		}
		
		Integer min = l2.stream().min((i1, i2) -> {
			if(i1<i2)
				return -1;
			if(i1>i2)
				return +1;
			else
				return 0;
    	}).get();
		System.out.println(min);
		
		Integer max = l2.stream().min((i1, i2) -> {
			if(i1<i2)
				return +1;
			if(i1>i2)
				return -1;
			else
				return 0;
    	}).get();
		System.out.println(max);
	}
}









