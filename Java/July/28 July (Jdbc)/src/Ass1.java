import java.sql.*;

public class Ass1 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("MySQL JDBC Driver Registered!");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");
		
		Statement st = con.createStatement();
		
		st.executeUpdate("create table if not exists employee(id int primary key, name varchar(50), salary double)");
		System.out.println("Table created!");
		
		st.executeUpdate("truncate table employee");

		int x = st.executeUpdate("insert into employee(id, name, salary) values(101, 'Harshita', 30000), (102, 'Mayuri', 40000), (103, 'Raksha', 50000)");
		System.out.println("\nData inserted! " + x);
		
		ResultSet rs = st.executeQuery("select * from employee");
		System.out.println("\nEmployee Details: ");
        while (rs.next()) 
        {
            System.out.println("ID: " + rs.getInt("id") +
            ", Name: " + rs.getString("name") +
            ", Salary: " + rs.getDouble("salary"));
        }
        System.out.println("\nAll data displayed!");
        
        int update = st.executeUpdate("update employee set salary = 40000 where id = 102");
        System.out.println("\nUpdated rows! " +update);
     
        int del = st.executeUpdate("delete from employee where id = 101");
        System.out.println("Deleted rows! " +del);
        
        ResultSet rs1 = st.executeQuery("select count(*) as total_employees from employee");
        if(rs1.next())
        {
        	System.out.println("Total employees: " + rs1.getInt(1));
        }
	}
}
