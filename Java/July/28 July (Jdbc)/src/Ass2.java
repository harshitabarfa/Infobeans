import java.sql.*;

public class Ass2 
{
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("MySQL JDBC Driver Registered!");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");
		
		Statement st = con.createStatement();
		st.executeUpdate("create table if not exists student(student_id int primary key, name varchar(50), age int, department varchar(50))");
		System.out.println("Table created!");
		
		st.executeUpdate("truncate table student");
		
		int x = st.executeUpdate("insert into student (student_id, name, age, department) values (1, 'Harshita', 20, 'CS'), (2, 'Mayuri', 17, 'IT'), (3, 'Vanshika', 14, 'CS'), (4, 'Tanishq', 18, 'EC'), (5, 'Raksha', 11, 'IT')");
		System.out.println("\nData inserted! " +x);

		ResultSet rs = st.executeQuery("select * from student");
		System.out.println("\nStudent Details: ");
        while (rs.next()) 
        {
            System.out.println("ID: " + rs.getInt("student_id") +
            ", Name: " + rs.getString("name") +
            ", Age: " + rs.getInt("age") + 
            ", Department: " + rs.getString("department"));
        }
        System.out.println("\nAll data displayed!");
        
        ResultSet rs1 = st.executeQuery("select * from student where department = 'IT'");
        System.out.println("\nStudent Details for specific department: ");
        while (rs1.next()) 
        {
            System.out.println("ID: " + rs1.getInt("student_id") +
            ", Name: " + rs1.getString("name") +
            ", Age: " + rs1.getInt("age") + 
            ", Department: " + rs1.getString("department"));
        }
        
        ResultSet rs2 = st.executeQuery("select * from student order by age desc limit 1");
        System.out.println("\nOlder student Details: ");
        while (rs2.next()) 
        {
            System.out.println("ID: " + rs2.getInt("student_id") +
            ", Name: " + rs2.getString("name") +
            ", Age: " + rs2.getInt("age") + 
            ", Department: " + rs2.getString("department"));
        }
        
        int y = st.executeUpdate("delete from student where age < 18");
        ResultSet rs3 = st.executeQuery("select * from student");
		System.out.println("\nAfter delete Students whose age below 18: ");
        while (rs3.next()) 
        {
            System.out.println("ID: " + rs3.getInt("student_id") +
            ", Name: " + rs3.getString("name") +
            ", Age: " + rs3.getInt("age") + 
            ", Department: " + rs3.getString("department"));
        }
	}
}











