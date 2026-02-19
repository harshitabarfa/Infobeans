import java.util.*;

class Employee implements Comparable<Employee>
{
	private String name;
	private double score;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public double getScore() 
	{
		return score;
	}
	
	public void setScore(double score) 
	{
		this.score = score;
	}
	
	public Employee() 
	{
		super();
	}

	public Employee(String name, double score) 
	{
		super();
		this.name = name;
		this.score = score;
	}

	public String toString() 
	{
		return "Employee [name=" + name + ", score=" + score + "]";
	}

	public int hashCode() 
	{
		return Objects.hash(name, score);
	}

	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score);
	}	

	public int compareTo(Employee o) 
	{
		return Double.compare(o.score, this.score);
	}
}

public class Ass5 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of employees: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		if (n < 1 || n > 100) 
		{
		    System.out.println("Invalid number of employees. Must be between 1 and 100.");
		    return;
		}
		
		ArrayList<Employee> a = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			String[] i1 = sc.nextLine().trim().split(" ");
			String name = i1[0];
			double score = Double.parseDouble(i1[1]);
			
			Employee e1 = new Employee(name, score);
			a.add(e1);
		}
		
		Collections.sort(a);
		System.out.println("\nDisplay details: ");
		for(Employee e2 : a)
		{
			System.out.println(e2.getName() + " " + e2.getScore());
		}	
	}
}



















