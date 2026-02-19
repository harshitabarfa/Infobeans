import java.sql.*;
import java.util.*;

public class Ass3
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");
		Statement st = con.createStatement();
		
		st.executeUpdate("create table if not exists employee(id int primary key auto_increment, name varchar(100), department varchar(100), salary double, email varchar(100))");
		System.out.println("Table is created!");
		
		st.executeUpdate("truncate table employee");
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println();
            System.out.println("\n1. Insert employee");
            System.out.println("2. Display All employee");
            System.out.println("3. Update employee Department");
            System.out.println("4. Delete employee");
            System.out.println("5. Exit");
            
            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            
            switch(choice)
            {
            case 1:
            	System.out.print("Enter name: ");
            	String name = sc.nextLine();
            	
            	System.out.print("Enter department: ");
            	String department = sc.nextLine();
            	
            	System.out.print("Enter salary: ");
            	double salary = Double.parseDouble(sc.nextLine());
            	
            	System.out.print("Enter email: ");
            	String email = sc.nextLine();
            	
            	String s = "insert into employee (name, department, salary, email) values ('" + name + "', '" + department + "', '" + salary + "', '" + email + "')";
            	int x = st.executeUpdate(s);
            	System.out.print("Data inserted!");
            	break;
            	
            case 2:
            	ResultSet rs = st.executeQuery("select * from employee");
            	while(rs.next())
            	{
            		System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Department: " + rs.getString("department") +
                            ", Salary: " + rs.getDouble("salary") +
                            ", E-mail: " + rs.getString("email"));
            	}
            	break;
            	
            case 3:
            	System.out.print("Enter employee Id to update: ");
            	int updateId = Integer.parseInt(sc.nextLine());
            	
            	System.out.print("Enter new salary: ");
            	double newSalary = Double.parseDouble(sc.nextLine());
            	
            	int s1 = st.executeUpdate("update employee set salary = " + newSalary + " where id = " + updateId);
            	System.out.println(s1 + " record updated.");
            	break;
            	
            case 4: 
            	System.out.print("Enter employee Id to delete: ");
            	int deleteId = Integer.parseInt(sc.nextLine());
            	
            	int s2 = st.executeUpdate("delete from employee where id = " + deleteId);
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













