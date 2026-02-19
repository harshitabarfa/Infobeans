class Employee
{
public void calculateSalary()
{
System.out.println( "Base salary calculation for Employee.");
}
}

class Manager extends Employee
{
private double salary;
private double bonus;

Manager(double salary, double bonus)
{
this.salary = salary;
this.bonus = bonus;
}

public void calculateSalary()
{
double total = salary + bonus;
System.out.println("Manager salary with bonus: " +total);
}
}

class Developer extends Employee
{
private int hoursWorked;
private double hourlyRate;

Developer(int hoursWorked, double hourlyRate)
{
this.hoursWorked = hoursWorked;
this.hourlyRate = hourlyRate;
}

public void calculateSalary()
{
double total = hoursWorked * hourlyRate;

System.out.println( "Base salary calculation for Employee: " +total);
}
}

class Ass5
{
public static void main(String args[])
{
Employee e[] = new Employee[3];

e[0] = new Employee();
e[1] = new Manager(20000, 5000);
e[2] = new Developer(120, 40);

for(Employee e1 : e)
{
e1.calculateSalary();
}

}
}









