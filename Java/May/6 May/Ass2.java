class Institution
{
String name;
String location;

public Institution(String name, String location)
{
this.name = name;
this.location = location;
}

void display()
{
System.out.println("Name: " + name);
System.out.println("Location: " + location);
}
}

class School extends Institution
{
int numOfStudents;

public School(String name, String location, int numOfStudents) 
{
super(name, location);
this.numOfStudents = numOfStudents;
}

void display() 
{
super.display();
System.out.println("Number of students: " + numOfStudents);
}
}

class College extends Institution
{
String courseOffered[];

public College(String name, String location, String courseOffered[]) 
{
super(name,location);
this.courseOffered = courseOffered;
}

void display() 
{
super.display();
System.out.print("Course Offered: ");
for (String course : courseOffered) 
{
System.out.print(course + " ");
}
System.out.println();
}
}

class University extends Institution 
{
String[] researchPrograms;

public University(String name, String location, String[] researchPrograms) 
{
super(name, location);
this.researchPrograms = researchPrograms;
}

void display() 
{
super.display();
System.out.print("Research Programs: ");
for (String program : researchPrograms) {
System.out.print(program + " ");
}
System.out.println();
}
}

class Ass2
{
public static void main(String args[])
{
School school = new School("Greenwood High", "Bangalore", 1200);
        
College college = new College("St. Joseph's College", "Mumbai", new String[]{"B.Com", "BBA", "BA"});
        
University university = new University("IIT Delhi", "Delhi", new String[]{"AI", "Robotics", "Quantum Computing"});

school.display();
System.out.println();
college.display();
System.out.println();
university.display();
}
}









