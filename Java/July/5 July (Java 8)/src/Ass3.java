import java.util.*;
import java.util.function.Function;

class Employee
{
	private int id;
	private String name;
	private double salary;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public double getSalary() 
	{
		return salary;
	}
	
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}

	public Employee(int id, String name, double salary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(id, name, salary);
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
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() 
	{
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}

public class Ass3 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many emplouee you want? ");
		int n = Integer.parseInt(sc.nextLine());
		
		ArrayList<Employee> a = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nEmployee " + (i+1) + " : ");
			
			System.out.print("Enter id: ");
			int id = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter salary: ");
			double salary = Double.parseDouble(sc.nextLine());
			
			Employee e = new Employee(id, name, salary);
			a.add(e);
		}
		
		Function<Employee, Employee> f = x -> {
			if(x.getSalary() < 50000)
			{
				double newSalary = x.getSalary() + x.getSalary() * 0.10;
				x.setSalary(newSalary);
			}
			return x;
		};
		
		System.out.println("\nDisplay details: ");
		for(Employee e1 : a)
		{
			System.out.println(f.apply(e1));
		}
	}
}














