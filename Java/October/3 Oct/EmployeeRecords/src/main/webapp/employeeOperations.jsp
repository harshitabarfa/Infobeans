<%@ page import="java.sql.*"%>
<%
String empIdStr = request.getParameter("empId");
String name = request.getParameter("name");
String designation = request.getParameter("designation");
String salaryStr = request.getParameter("salary");
String dept = request.getParameter("department");
String action = request.getParameter("action");

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");

	switch (action) {
	case "insert": {
		int empId = Integer.parseInt(empIdStr);
		double salary = Double.parseDouble(salaryStr);
		PreparedStatement ps = con.prepareStatement(
		"INSERT INTO employee(empId, name, designation, salary, department) VALUES (?,?,?,?,?)");
		ps.setInt(1, empId);
		ps.setString(2, name);
		ps.setString(3, designation);
		ps.setDouble(4, salary);
		ps.setString(5, dept);
		int x = ps.executeUpdate();
		out.print(x > 0 ? "<p style='color:green;'>Employee Inserted Successfully</p>"
		: "<p style='color:red;'>Insert Failed</p>");
		ps.close();
		break;
	}
	case "update": {
		int empId = Integer.parseInt(empIdStr);
		double salary = Double.parseDouble(salaryStr);
		PreparedStatement ps = con
		.prepareStatement("UPDATE employee SET name=?, designation=?, salary=?, department=? WHERE empId=?");
		ps.setString(1, name);
		ps.setString(2, designation);
		ps.setDouble(3, salary);
		ps.setString(4, dept);
		ps.setInt(5, empId);
		int x = ps.executeUpdate();
		out.print(x > 0 ? "<p style='color:blue;'>Employee Updated Successfully</p>"
		: "<p style='color:red;'>Update Failed</p>");
		ps.close();
		break;
	}
	case "delete": {
		int empId = Integer.parseInt(empIdStr);
		PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE empId=?");
		ps.setInt(1, empId);
		int x = ps.executeUpdate();
		out.print(x > 0 ? "<p style='color:red;'>Employee Deleted Successfully</p>"
		: "<p style='color:red;'>Delete Failed</p>");
		ps.close();
		break;
	}
	case "view": {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM employee");
		out.println("<h2>All Employees</h2>");
		out.println("<table border='1' cellpadding='10' style='border-collapse: collapse;'>");
		out.println("<tr><th>ID</th><th>Name</th><th>Designation</th><th>Salary</th><th>Department</th></tr>");
		boolean hasData = false;
		while (rs.next()) {
	hasData = true;
	out.println("<tr>");
	out.println("<td>" + rs.getInt("empId") + "</td>");
	out.println("<td>" + rs.getString("name") + "</td>");
	out.println("<td>" + rs.getString("designation") + "</td>");
	out.println("<td>" + rs.getDouble("salary") + "</td>");
	out.println("<td>" + rs.getString("department") + "</td>");
	out.println("</tr>");
		}
		out.println("</table>");
		if (!hasData)
	out.println("<p>No Employees Found</p>");
		rs.close();
		st.close();
		break;
	}
	default:
		out.print("<p>Unknown Action: " + action + "</p>");
	}

	con.close();
} catch (Exception e) {
	out.print("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
}
%>
<br>
<a href="index.jsp">Back</a>

