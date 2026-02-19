import java.util.*;

class Student
{
	private String StudentName;
	private int StudentId;
	private String studentCourse;
	
	public String getStudentName() 
	{
		return StudentName;
	}
	
	public void setStudentName(String studentName) 
	{
		StudentName = studentName;
	}
	
	public int getStudentId() 
	{
		return StudentId;
	}
	
	public void setStudentId(int studentId) 
	{
		StudentId = studentId;
	}
	
	public String getStudentCourse() 
	{
		return studentCourse;
	}
	
	public void setStudentCourse(String studentCourse) 
	{
		this.studentCourse = studentCourse;
	}

	public Student(String studentName, int studentId, String studentCourse) 
	{
		super();
		StudentName = studentName;
		StudentId = studentId;
		this.studentCourse = studentCourse;
	}

	@Override
	public String toString() 
	{
		return "Student [StudentName=" + StudentName + ", StudentId=" + StudentId + ", studentCourse=" + studentCourse
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(StudentId, StudentName, studentCourse);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		return StudentId == other.StudentId && Objects.equals(StudentName, other.StudentName)
				&& Objects.equals(studentCourse, other.studentCourse);
	}
}

public class Ass4 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		HashSet<Student> h = new HashSet<Student>();
		
		System.out.print("Enter number of students: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nStudent " + (i+1) + ":");
			
			System.out.print("Enter student name: ");
			String studentName = sc.nextLine();
			
			System.out.print("Enter student id: ");
			int studentId = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter student course: ");
			String studentCourse = sc.nextLine();
			
			Student s = new Student(studentName, studentId, studentCourse);
			
		    if (!h.add(s)) 
		    {
                System.out.println("\nDuplicate student ID. Entry not added.");
            }
		}
		
		System.out.println("\nList of all Student: ");
		for(Student s : h)
		{
			System.out.println(s);
		}
	}
}












