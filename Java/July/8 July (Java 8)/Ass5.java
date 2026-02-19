import java.util.*;
import java.util.stream.*;

class Student3
{
    private String name;
    private int age;
    private int marks;

    public Student3(String name, int age, int marks) 
    {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getName() 
    {
        return name;
    }

    public int getMarks() 
    {
        return marks;
    }

    public int getAge() 
    {
        return age;
    }

    @Override
    public String toString() 
    {
        return "Student [name=" + name + ", age=" + age + ", marks=" + marks + "]";
    }
}

public class Ass5 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many students: ");
        int n = Integer.parseInt(sc.nextLine());

        List<Student3> l = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            System.out.println("\nStudent " + (i + 1) + ":");

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Enter marks: ");
            int marks = Integer.parseInt(sc.nextLine());

            Student3 s = new Student3(name, age, marks);
            l.add(s);
        }
        
        List<String> s1 = l.stream()
                .filter(x -> x.getMarks() > 50)
                .sorted((i1,i2) -> {
        			if(i1.getMarks()<i2.getMarks())
        				return +1;
        			else if(i1.getMarks()>i2.getMarks())
        				return -1;
        			else
        				return 0;
        		}).limit(3)
                .map(x -> x.getName().toUpperCase())
                .collect(Collectors.toList());

        System.out.println("\nTop 3 Performers (Passed & in Uppercase): " + s1);
	}
}















