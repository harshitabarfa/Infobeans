import java.util.*;

class Employee 
{
private int employeeId;
private String employeeName;
private String department;
private String designation;
private float salary;

public void setEmployeeId(int empId) 
{
employeeId = empId;
}

public int getEmployeeId() 
{
return employeeId;
}

public void setEmployeeName(String empName) 
{
this.employeeName = empName;
}

public String getEmployeeName() 
{
return employeeName;
}

public void setDepartment(String d) 
{
department = d;
}

public String getDepartment() 
{
return department;
}

public void setDesignation(String d) 
{
designation = d;
}

public String getDesignation() 
{
return designation;
}

public void setSalary(float newSalary) 
{
salary = newSalary;
}

public float getSalary() 
{
return salary;
}
}

class Ass3 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

Employee e = new Employee();

System.out.print("Enter Employee ID: ");
int employeeId = sc.nextInt();
e.setEmployeeId(employeeId);

sc.nextLine();

System.out.print("Enter Employee Name: ");
String employeeName = sc.nextLine();
e.setEmployeeName(employeeName);

System.out.print("Enter Department: ");
String department = sc.nextLine();
e.setDepartment(department);

System.out.print("Enter Designation: ");
String designation = sc.nextLine();
e.setDesignation(designation);

System.out.print("Enter Salary: ");
float salary = sc.nextFloat();
e.setSalary(salary);

System.out.println("Employee Details:");
System.out.println("Employee ID: " + e.getEmployeeId());
System.out.println("Employee Name: " + e.getEmployeeName());
System.out.println("Department: " + e.getDepartment());
System.out.println("Designation: " + e.getDesignation());
System.out.println("Salary: " + e.getSalary());

}
}