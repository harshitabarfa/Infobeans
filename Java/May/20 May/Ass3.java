import java.util.*;

interface LibraryOperations
{
public void issueBook();
public void returnBook();
}

class Student implements LibraryOperations
{
public void issueBook()
{
System.out.println("Student can issue up to 3 books for 15 days.");
}

public void returnBook()
{
System.out.println("Student must return books within 15 days to avoid a fine.");
}
}

class Teacher implements LibraryOperations
{
public void issueBook()
{
System.out.println("Teacher can issue up to 10 books for 60 days.");
}

public void returnBook()
{
System.out.println("Teacher must return books within 60 days.");
}
}

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Are you a student or a teacher? ");
String ut = sc.nextLine().toLowerCase();

LibraryOperations user;

if(ut.equals("student"))
{
user = new Student();
}
else if(ut.equals("teacher"))
{
user = new Teacher();
}
else
{
System.out.println("Invalid user type!");
return;
}
user.issueBook();
user.returnBook();
}
}
















