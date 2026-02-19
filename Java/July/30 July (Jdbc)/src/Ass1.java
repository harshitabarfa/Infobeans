import java.sql.*;
import java.util.*;

public class Ass1 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");
		Statement st = con.createStatement();
		
		st.executeUpdate("create table if not exists student(id int primary key auto_increment, name varchar(50) not null, age int check (age >= 18), marks int check (marks between 0 and 100) ,course varchar(50) not null)");
		System.out.println("Table is created!");
		
		st.executeUpdate("truncate table student");
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println();
            System.out.println("\n1. Insert Student");
            System.out.println("2. Display Students with Marks > 80");
            System.out.println("3. Display Students aged between 20 and 25");
            System.out.println("4. Display Students enrolled in a specific course");
            System.out.println("5. Update Student Marks");
            System.out.println("6. Delete Student by ID");
            System.out.println("7. Find Students whose names start with 'A'");
            System.out.println("8. Exit");
            
            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            
            switch(choice)
            {
            case 1:
            	System.out.print("Enter name: ");
            	String name = sc.nextLine();
            	
            	System.out.print("Enter age: ");
            	int age = Integer.parseInt(sc.nextLine());
            	
            	System.out.print("Enter marks: ");
            	int marks = Integer.parseInt(sc.nextLine());
            	
            	System.out.print("Enter course: ");
            	String course = sc.nextLine();
            	
            	String s = "insert into student (name, age, marks, course) values ('" + name + "', " + age + ", " + marks + ", '" + course + "')";
            	int x = st.executeUpdate(s);
            	System.out.print("Data inserted!");
            	break;
            	
            case 2:
            	ResultSet rs = st.executeQuery("select * from student where marks > 80");
            	while(rs.next())
            	{
            		System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Age: " + rs.getInt("age") +
                            ", Marks: " + rs.getInt("marks") +
                            ", Course: " + rs.getString("course"));
            	}
            	break;
            	
            case 3:
            	ResultSet rs1 = st.executeQuery("select * from student where age between 20 and 25");
            	while(rs1.next())
            	{
            		System.out.println("ID: " + rs1.getInt("id") +
                            ", Name: " + rs1.getString("name") +
                            ", Age: " + rs1.getInt("age") +
                            ", Marks: " + rs1.getInt("marks") +
                            ", Course: " + rs1.getString("course"));
            	}
            	break;
            	
            case 4: 
            	System.out.print("Enter course: ");
            	String findC = sc.nextLine();
            	
            	ResultSet rs2 = st.executeQuery("select * from student where course = '" + findC + "'");
                while (rs2.next()) 
                {
                    System.out.println("ID: " + rs2.getInt("id") +
                            ", Name: " + rs2.getString("name") +
                            ", Age: " + rs2.getInt("age") +
                            ", Marks: " + rs2.getInt("marks") +
                            ", Course: " + rs2.getString("course"));
                }
            	break;
          
            	
            case 5:
            	System.out.print("Enter student Id to update marks: ");
            	int updateId = Integer.parseInt(sc.nextLine());
            	
            	System.out.print("Enter new marks: ");
            	int newM = Integer.parseInt(sc.nextLine());
            	
            	int s1 = st.executeUpdate("update student set marks = '" + newM + "' where id = " + updateId);
            	System.out.println(s1 + " record updated.");
            	break;
            	
            case 6:
            	System.out.print("Enter student id to delete: ");
                int deleteId = Integer.parseInt(sc.nextLine());
                
                int s2 = st.executeUpdate("delete from student where id = " + deleteId);
                System.out.println(s2 + " record deleted.");
                break;
                
            case 7:
            	ResultSet rs3 = st.executeQuery("select * from student where name like 'A%'");
                while (rs3.next()) 
                {
                    System.out.println("ID: " + rs3.getInt("id") +
                            ", Name: " + rs3.getString("name") +
                            ", Age: " + rs3.getInt("age") +
                            ", Marks: " + rs3.getInt("marks") +
                            ", Course: " + rs3.getString("course"));
                }
                break;
            	
            case 8:
            	 System.out.println("Exiting program...!!");
                 break;
                
            default:
            	System.out.println("Invalid choice. Try again.");
            }
		}while(choice != 8);
	}
}













