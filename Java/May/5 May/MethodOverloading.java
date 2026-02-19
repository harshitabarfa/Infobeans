class Student
{
public void sum(int x, int y)
{
System.out.println(x+y);
}

public void sum(int x, int y, int z)
{
System.out.println(x+y+z);
}

public void sum(double x, double y)
{
System.out.println(x+y);
}

public void sum(int x, double y)
{
System.out.println(x+y);
}
 
public void sum(double x, int y)
{
System.out.println(x+y);
}
}

class MethodOverloading
{
public static void main(String args[])
{
Student s1 = new Student();

s1.sum(10,20);
s1.sum(10,20,30);
s1.sum(10.25,20.19);
s1.sum(10,20.19);
s1.sum(10.34,20);
}
}