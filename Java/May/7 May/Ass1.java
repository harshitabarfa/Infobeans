import java.util.*;

class Person
{
String firstName;
String lastName;

Person(String firstName, String lastName)
{
this.firstName = firstName;
this.lastName = lastName;
}
}

class Employee extends Person
{
int employeeId;
String jobTitle;
Employee(String firstName, String lastName, int employeeId, String jobTitle)
{
super(firstName,lastName);
this.employeeId = employeeId;
this.jobTitle = jobTitle;
}

public void setFirstName(String firstName)
{
this.firstName = firstName;
}

public String getFirstName()
{
return firstName;
}

public void setLastName(String lastName)
{
this.lastName = lastName;
}

public String getLastName()
{
return lastName;
}

public void setEmployeeId(int employeeId)
{
this.employeeId = employeeId;
}

public int getEmployeeId()
{
return employeeId;
}

public void setJobTitle(String jobTitle)
{
this.jobTitle = jobTitle;
}

public String getJobTitle()
{
return jobTitle;
}
}
class Ass1
{
public static void main(String arags[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter size: ");
int size = sc.nextInt();
sc.nextLine();

System.out.println();
Employee[] e = new Employee[size];

for(int i = 0; i<size; i++)
{
String firstName = sc.nextLine();
String lastName = sc.nextLine();
int employeeId = sc.nextInt();
sc.nextLine();
String jobTitle = sc.nextLine();

e[i] = new Employee(firstName, lastName, employeeId, jobTitle);
System.out.println();
}


for(Employee e1 : e)
{
System.out.println();
System.out.println("First name: " +e1.getFirstName());
System.out.println("Last name: " +e1.getLastName());
System.out.println("Employee id: " +e1.getEmployeeId());
System.out.println("Job title: " +e1.getJobTitle());
}
}
}
















