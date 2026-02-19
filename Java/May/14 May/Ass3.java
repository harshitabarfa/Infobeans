abstract class Course 
{
String courseName;
int duration;

Course(String courseName, int duration) 
{
this.courseName = courseName;
this.duration = duration;
}

abstract void showContent();

void displayDetails() 
{
System.out.println("Course Name: " + courseName);
System.out.println("Duration: " + duration + " weeks");
}
}

class ProgrammingCourse extends Course 
{
String language;

ProgrammingCourse(String courseName, int duration, String language) 
{
super(courseName, duration);
this.language = language;
}

void showContent() 
{
System.out.println("This course covers programming in " + language + ".");
}
}

class DesignCourse extends Course 
{
String tool;

DesignCourse(String courseName, int duration, String tool) 
{
super(courseName, duration);
this.tool = tool;
}

void showContent() 
{
System.out.println("This course focuses on design using " + tool + ".");
}
}

public class Ass3 
{
public static void main(String[] args) 
{
ProgrammingCourse pc = new ProgrammingCourse("Java Programming", 6, "Java");
DesignCourse dc = new DesignCourse("Graphic Design", 4, "Photoshop");

pc.showContent();
pc.displayDetails();

System.out.println();

dc.showContent();
dc.displayDetails();
}
}