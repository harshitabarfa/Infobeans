import java.util.*;

class Employee
{
int empId;
float salary;

Employee(int empId, float salary)
{
this.empId = empId;
this.salary = salary;
}
}
class EmployeeLevel extends Employee
{
EmployeeLevel(int empId, float salary)
{
super(empId, salary);
}

public int getLevel() 
{
if (salary > 100.0) 
{
return 1;
} 
else 
{
return 2;
}
}
}

class Ass3 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

int empId = sc.nextInt();
float salary = sc.nextFloat();

EmployeeLevel emp = new EmployeeLevel(empId, salary);

System.out.println(emp.empId);
System.out.println(emp.salary);
        System.out.println(emp.getLevel());
}
}











