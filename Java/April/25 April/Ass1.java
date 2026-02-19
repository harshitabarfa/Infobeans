import java.util.*;

class StudentRecord 
{
private String name;
private int rollNo;
private String grade;
private char section;
private double percentage;

public void setName(String n) 
{
name = n;
}

public String getName() 
{
return name;
}

public void setNo(int num) 
{
rollNo = num;
}

public int getNo() 
{
return rollNo;
}

public void setGrade(String g) 
{
grade = g;
}

public String getGrade() 
{
return grade;
}

public void setSection(char c) 
{
section = c;
}

public char getSection() 
{
return section;
}

public void setPercentage(double p) 
{
percentage = p;
}

public double getPercentage() 
{
return percentage;
}

}

class Ass1 
{
public static void main(String args[]) 
{
Scanner sc = new Scanner(System.in);

StudentRecord s = new StudentRecord();

System.out.print("Enter name: ");
String name = sc.nextLine();
s.setName(name);

System.out.print("Enter roll number: ");
int rollNo = sc.nextInt();
s.setNo(rollNo);

sc.nextLine();

System.out.print("Enter grade: ");
String grade = sc.nextLine();
s.setGrade(grade);

System.out.print("Enter section: ");
char section = sc.next().charAt(0);
s.setSection(section);

System.out.print("Enter percentage: ");
double percentage = sc.nextDouble();
s.setPercentage(percentage);

System.out.println("Student Record:");
System.out.println("Name: " + s.getName());
System.out.println("Roll No: " + s.getNo());
System.out.println("Grade: " + s.getGrade());
System.out.println("Section: " + s.getSection());
System.out.println("Percentage: " + s.getPercentage() + "%");

}
}
