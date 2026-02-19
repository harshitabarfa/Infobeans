import java.util.*;
import java.util.function.Predicate;

class Employee
{
	private int id;
	private String name;
	private int experience;
	private double rating;
	
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
	
	public int getExperience() 
	{
		return experience;
	}
	
	public void setExperience(int experience) 
	{
		this.experience = experience;
	}
	
	public double getRating() 
	{
		return rating;
	}
	
	public void setRating(double rating) 
	{
		this.rating = rating;
	}

	public Employee(int id, String name, int experience, double rating) 
	{
		super();
		this.id = id;
		this.name = name;
		this.experience = experience;
		this.rating = rating;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(experience, id, name, rating);
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
		return experience == other.experience && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", experience=" + experience + ", rating=" + rating + "]";
	}
}

public class Ass4 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employee you want? ");
		int n = Integer.parseInt(sc.nextLine());
		
	    ArrayList<Employee> a = new ArrayList<>();
		 
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nEmployee " + (i+1) + " : ");
			
			System.out.print("Enter employee id: ");
			int id = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter employee name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter experience(in years): ");
			int experience = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter rating(out of 5.0): ");
			double rating = Double.parseDouble(sc.nextLine());
			
			Employee e = new Employee(id, name, experience, rating);
			a.add(e);
		}
		
		ArrayList<Employee> a1 = new ArrayList();
		Predicate<Employee> p = p1 -> p1.getExperience() >= 3 && p1.getRating() >= 4.2;
		
		for(Employee e1 : a)
		{
			if(p.test(e1))
			{
				a1.add(e1);
			}
		}
		
		if(a1.size() == 0)
		{
			System.out.println("\nNo employee met the criteria!");
		}
		else
		{
		System.out.println("\nDisplay employee products: ");
		}
		
		for(Employee e2 : a1)
		{
			System.out.println(e2);
		}
	}
}











