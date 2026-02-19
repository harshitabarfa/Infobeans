import java.util.*;

class Student 
{
private String name; 
private String studentId;
private String department;
private String[] courseNames;
private int[] courseCredits;

public Student(String name, String studentId, String department, String[] courseNames, int[] courseCredits) 
{
this.name = name;
this.studentId = studentId;
this.department = department;
this.courseNames = courseNames;
this.courseCredits = courseCredits;
}

public void display() 
{
for (int i = 0; i < courseNames.length; i++) 
{            
System.out.println(courseNames[i] + " - Credits: " + courseCredits[i]);
}
}

public int totalCredits() 
{
int sum = 0;

for (int credit : courseCredits) sum += credit;
return sum;
}

public String highestCreditCourse() 
{
int max = courseCredits[0];
String course = courseNames[0];

for (int i = 1; i< courseCredits.length; i++) 
{
if (courseCredits[i] > max) 
{
max = courseCredits[i];
course = courseNames[i];
}
}
        
return course + " (Credits: " + max + ")";
}
}

class Ass3
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter student name: ");
String name = sc.nextLine();
        
System.out.print("Enter student ID: ");
String studentId = sc.nextLine();
        
System.out.print("Enter department: ");
String department = sc.nextLine();

System.out.print("Number of courses: ");
int n = sc.nextInt();
sc.nextLine();

String[] courseNames = new String[n];
int[] courseCredits = new int[n];
        
for (int i = 0; i < n; i++) 
{
System.out.print("Course " + (i+1) + " name: ");
courseNames[i] = sc.nextLine();
            
System.out.print("Credits for " + courseNames[i] + ": ");

courseCredits[i] = sc.nextInt();
sc.nextLine();
}

Student student = new Student(name, studentId, department, courseNames, courseCredits);

System.out.println("Enrollment Details: ");
        
student.display();

System.out.println("Total Credits: " + student.totalCredits());
System.out.println("Course with highest credit: " + student.highestCreditCourse());

}
}
