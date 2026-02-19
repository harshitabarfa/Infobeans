import java.util.*;

class Student
{
private int id;
private String name;
private int grade;

public int getId()
{
return id;
}

public String getName()
{
return name;
}

public int getGrade()
{
return grade;
}

public Student(int id, String name, int grade)
{
this.id = id;
this.name = name;
this.grade = grade;
}
}

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number of students: ");
int n = sc.nextInt();
sc.nextLine();

System.out.println();
Student st[] = new Student[n];

for(int i=0; i<n; i++)
{
System.out.println("Details for Student " + (i+1) + ":");

System.out.print("Enter student id: ");
int id = sc.nextInt();
sc.nextLine();

System.out.print("Enter student name: ");
String name = sc.nextLine();

System.out.print("Enter student grade: ");
int grade = sc.nextInt();

st[i] = new Student(id, name, grade);

System.out.println();
}

int totalGrades = 0;

System.out.println("Display Student details: ");
for(Student s : st)
{
System.out.println("Student Id: " +s.getId());
System.out.println("Student Name: " +s.getName());
System.out.println("Student Grade: " +s.getGrade());

totalGrades += s.getGrade();

System.out.println();
}

double avg = totalGrades / n;

System.out.printf("Average Grade: " +avg);

}
}






