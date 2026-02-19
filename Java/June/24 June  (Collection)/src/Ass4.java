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

	public Employee(String employeeName, int employeeId, String employeeDepartment) 
	{
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeDepartment = employeeDepartment;
	}

	public String toString() 
	{
		return "Employee [employeeName = " + employeeName + ", employeeId = " + employeeId + ", employeeDepartment = "
				+ employeeDepartment + "]";
	}	
}

public class Ass4 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of ArrayList elements: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		ArrayList<Employee> e = new ArrayList<Employee>();
		
		System.out.println();
		for (int i = 0; i < size; i++) 
		{
			System.out.println("Enter details for employees " + (i + 1) + ":");
						
			System.out.print("Enter Employee Name: ");
			String employeeName = sc.nextLine();

			System.out.print("Enter EmpLoyee Id: ");
			int employeeId = Integer.parseInt(sc.nextLine());

			System.out.print("Enter Employee Department: ");
			String employeeDepartment = sc.nextLine();
			
			Employee e1 = new Employee(employeeName, employeeId, employeeDepartment);
			e.add(e1);

			System.out.println();
		}
		
		for(Employee e2 : e)
		{
			System.out.println("List of All Employees: " + e2);
		}
	}
}
