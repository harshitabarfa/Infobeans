import java.util.*;

class Employee
{
	private String employeeName;
	private int employeeId;
	private String employeeDepartment;
	
	public String getEmployeeName() 
	{
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}
	
	public int getEmployeeId() 
	{
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) 
	{
		this.employeeId = employeeId;
	}
	
	public String getEmployeeDepartment() 
	{
		return employeeDepartment;
	}
	
	public void setEmployeeDepartment(String employeeDepartment) 
	{
		this.employeeDepartment = employeeDepartment;
	}

	public String toString() 
	{
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", employeeDepartment="
				+ employeeDepartment + "]";
	}

	public Employee(String employeeName, int employeeId, String employeeDepartment) 
	{
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeDepartment = employeeDepartment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeDepartment, employeeId, employeeName);
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
		return Objects.equals(employeeDepartment, other.employeeDepartment) && employeeId == other.employeeId
				&& Objects.equals(employeeName, other.employeeName);
	}
}

public class Ass3 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		HashSet<Employee> h = new HashSet<Employee>();
		
		System.out.print("Enter a number of employee: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nEmployee " + (i+1) + ":");
			
			System.out.print("Enter employee name: ");
			String employeeName = sc.nextLine();
			
			System.out.print("Enter employee id: ");
			int employeeId = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter employee department: ");
			String employeeDepartment = sc.nextLine();
			
			h.add(new Employee(employeeName, employeeId, employeeDepartment));
		}
		
		System.out.println("\nDisplay the list of employees:");
		for(Employee e: h)
		{
			System.out.println(e);
		}
	}
}





