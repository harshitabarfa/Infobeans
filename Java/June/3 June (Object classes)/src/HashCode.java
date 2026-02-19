import java.util.Objects;

class Person1
{
	int id;
	String name;
	int salary;
	
	public int getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	Person1(int id, String name, int salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int hashCode()
	{
		return Objects.hash(id,name,salary);
	}
}

public class HashCode
{
	public static void main(String[] args) 
	{
		Person1 p1 = new Person1(101, "Harshita", 80000);
		System.out.println(p1);
		
		Person1 p2 = new Person1(102, "Harshita", 80000);
		System.out.println(p2);
		
		Person1 p3 = p1;
		
		int i = 10;
		int j = 10;
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
	}

}
