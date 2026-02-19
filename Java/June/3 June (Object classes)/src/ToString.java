class Person
{
	private int id;
	private String name;
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
	
	Person(int id, String name, int salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString()
	{
		return id + ":" + name + ":" +  salary;
	}
}

class Employee extends Person
{
	String department;
	
	Employee(int id, String name, int salary, String department)
	{
		super(id, name, salary);
		this.department = department;
	}
	
	public String toString()
	{
		return getId() + ":" + getName() + ":" +  getSalary() + ":" + department;
	}
}

public class ToString 
{
	public static void main(String[] args) 
	{
		// Person p = new Person(101, "Harshita", 80000);
		// System.out.println(p);
		
		Employee e = new Employee(101, "Harshita", 80000, "CS");
		System.out.println(e);
		
		// String s = p + " Hello";
		// System.out.println(s);
		
		// Integer i = new Integer(10);
		// System.out.println(i);
	}

}
