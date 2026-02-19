import java.sql.*;
import java.util.*;

public class Ass1 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");
		Statement st = con.createStatement();
		
		st.executeUpdate("create table if not exists student(id int primary key auto_increment, name varchar(50), age int, department varchar(50))");
		System.out.println("Table is created!");
		
		st.executeUpdate("truncate table student");
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println();
            System.out.println("\n1. Insert Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Update Student Department");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            
            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            
            switch(choice)
            {
            case 1:
            	System.out.print("Enter name: ");
            	String name = sc.nextLine();
            	
            	System.out.print("Enter age: ");
            	int age = Integer.parseInt(sc.nextLine());
            	
            	System.out.print("Enter department: ");
            	String department = sc.nextLine();
            	
            	String s = "insert into student (name, age, department) values ('" + name + "', " + age + ", '" + department + "')";
            	int x = st.executeUpdate(s);
            	System.out.print("Data inserted!");
            	break;
            	
            case 2:
            	ResultSet rs = st.executeQuery("select * from student");
            	while(rs.next())
            	{
            		System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Age: " + rs.getInt("age") +
                            ", Department: " + rs.getString("department"));
            	}
            	break;
            	
            case 3:
            	System.out.print("Enter student Id to update: ");
            	int updateId = Integer.parseInt(sc.nextLine());
            	
            	System.out.print("Enter new department: ");
            	String newDept = sc.nextLine();
            	
            	int s1 = st.executeUpdate("update student set department = '" + newDept + "' where id = " + updateId);
            	System.out.println(s1 + " record updated.");
            	break;
            	
            case 4: 
            	System.out.print("Enter student Id to delete: ");
            	int deleteId = Integer.parseInt(sc.nextLine());
            	
            	int s2 = st.executeUpdate("delete from student where id = " + deleteId);
            	System.out.println(s2 + " record deleted.");
            	break;
            	
            case 5:
            	 System.out.println("Exiting program...!!");
                 break;
                
            default:
            	System.out.println("Invalid choice. Try again.");
            }
		}while(choice != 5);
	}
}













