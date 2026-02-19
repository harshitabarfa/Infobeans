import java.util.*;

class Student 
{
String name;
int age;
String dept;
double gpa;
}

public class Ass3 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
        
Student[] s = new Student[100];
int count = 0;

while (true) 
{
System.out.println("1. Add Student");

System.out.println("2. View All Students");

System.out.println("3. Students with GPA above value");

System.out.println("4. Students from a Department");

System.out.println("5. Students below an Age");
            
System.out.println("6. Exit");
            
System.out.print("Enter choice: ");
int choice = sc.nextInt();
            
sc.nextLine();

if (choice == 1) 
{
Student s1 = new Student();
System.out.print("Enter name: ");
s1.name = sc.nextLine();

System.out.print("Enter age: ");
s1.age = sc.nextInt();
sc.nextLine();
                
System.out.print("Enter department: ");
s1.dept = sc.nextLine();

System.out.print("Enter GPA: ");
s1.gpa = sc.nextDouble();
sc.nextLine();

s[count] = s1;
count++;
                System.out.println("Student added.");
} 

else if (choice == 2) 
{
for (int i = 0; i < count; i++) 
{
Student s2 = s[i];
                    System.out.println(s2.name + ", " + s2.age + ", " + s2.dept + ", " + s2.gpa);
}
} 

else if (choice == 3) 
{
System.out.print("Enter GPA value: ");
double g = sc.nextDouble();
sc.nextLine();
                
for (int i = 0; i < count; i++) 
{
if (s[i].gpa > g) 
{                       
System.out.println(s[i].name + ", GPA: " + s[i].gpa);
}
}
} 

else if (choice == 4) 
{
System.out.print("Enter department: ");
String d = sc.nextLine();
                
for (int i = 0; i < count; i++) 
{
if(s[i].dept.equalsIgnoreCase(d)) {                       
System.out.println(s[i].name + ", Dept: " + s[i].dept);
}
}
} 
else if (choice == 5) 
{
System.out.print("Enter age: ");
int a = sc.nextInt();
sc.nextLine();
                
for (int i = 0; i < count; i++) 
{
if (s[i].age < a) 
{                        
System.out.println(s[i].name + ", Age: " + s[i].age);
}
}
} 
else if (choice == 6) 
{               
System.out.println("Goodbye!");
break;
} 
else 
{                
System.out.println("Invalid choice. Try again.");
}
}
}
}
