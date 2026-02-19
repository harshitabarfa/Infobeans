import java.util.*;

class Student
{
private String name;
private int marks[];

public Student(String name, int marks[])
{
this.name = name;
this.marks = marks;
}

public int cal_Total()
{
int total = 0;
for(int mark : marks)
{
total+=mark;
}
return total;
}

public double cal_Avg()
{
return cal_Total() / 5.0;
}

public char getGrade() 
{
double avg = cal_Avg();

if (avg >= 90) 
return 'A';

else if (avg >= 75) 
return 'B';

else if (avg >= 60)
return 'C';

else if (avg >= 40) 
return 'D';

else 
return 'F';
}

public void display() 
{
System.out.println("Name: " + name);
System.out.println("Total Marks: " + cal_Total());
System.out.println("Average Marks: "
+cal_Avg());
System.out.println("Grade: " + getGrade());
}
}

class Ass1 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter student name: ");
String name = sc.nextLine();

int[] marks = new int[5];
System.out.println("Enter marks for 5 subjects:");
        
for (int i = 0; i < 5; i++) 
{
System.out.print("Subject " + (i + 1) + ": ");
marks[i] = sc.nextInt();
}

Student student = new Student(name, marks);
        
student.display();

}
}









