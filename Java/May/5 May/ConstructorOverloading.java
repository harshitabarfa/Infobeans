class Student
{
Student()
{
System.out.println("Default constructor");
}

Student(int x, int y)
{
System.out.println("Two para constructor");
}

Student(double x, double y)
{
System.out.println("Two para double type");
}
}

class ConstructorOverloading
{
public static void main(String args[])
{

Student s1 = new Student();
Student s2 = new Student(10,20);
Student s3 = new Student(10.23, 20.17);

}
}