class Person2
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
	
	Person2(int id, String name, int salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public boolean equals(Person2 p)
	{
		return this.id == p.id && this.name.equals(p.name) && this.salary == p.salary;
	}
}

public class EqualMethod
{
	public static void main(String[] args) 
	{
		Person2 p1 = new Person2(101, "Harshita", 80000);
		System.out.println(p1);
		
		Person2 p2 = new Person2(101, "Harshita", 80000);
		System.out.println(p2);
		
		int i = 10;
		int j = 10;
		
		System.out.println(i==j); // True
		System.out.println(p1==p2); // False
		
		Person2 p3 = p1;
		System.out.println(p3==p1); // True
		
		System.out.println(p1.equals(p2)); // True
	}

}
