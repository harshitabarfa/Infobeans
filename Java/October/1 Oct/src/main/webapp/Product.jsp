<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management</title>
</head>
<body>
	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");

		String id = request.getParameter("ID");
		String name = request.getParameter("Name");
		String category = request.getParameter("Category");
		String price = request.getParameter("Price");
		String quantity = request.getParameter("Quantity");
		String action = request.getParameter("action");

		switch (action) {
		case "insert":
			PreparedStatement ps = con
			.prepareStatement("Insert into Product (id,name,category,price,quantity) values (?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setString(3, category);
			ps.setDouble(4, Double.parseDouble(price));
			ps.setInt(5, Integer.parseInt(quantity));

			ps.executeUpdate();
			out.println("<h2>Insert successfully!</h2>");

			ps.close();
			break;

		case "view":
			PreparedStatement psV = psV = con.prepareStatement("Select * from Product");
			ResultSet rs = psV.executeQuery();

			out.println("<h3>All Products:</h3>");
			out.println("<table border='1'>");
			out.println("<tr><th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Quantity</th></tr>");

			while (rs.next()) {
		out.println("<tr>");
		out.println("<td>" + rs.getInt("id") + "</td>");
		out.println("<td>" + rs.getString("name") + "</td>");
		out.println("<td>" + rs.getString("category") + "</td>");
		out.println("<td>" + rs.getDouble("price") + "</td>");
		out.println("<td>" + rs.getInt("quantity") + "</td>");
		out.println("</tr>");
			}

			out.println("</table>");

			rs.close();
			psV.close();
			break;

		case "update":
			PreparedStatement psU = con
			.prepareStatement("Update Product set name = ?, category = ?, price = ?, quantity = ? where id = ?");
			psU.setString(1, name);
			psU.setString(2, category);
			psU.setDouble(3, Double.parseDouble(price));
			psU.setInt(4, Integer.parseInt(quantity));
			psU.setInt(5, Integer.parseInt(id));

			int updated = psU.executeUpdate();
			if (updated > 0) {
		out.println("<h3>Updated successfully!</h3>");
			} else {
		out.println("<h3>Product not found!</h3>");
			}
			psU.close();
			break;

		case "delete":
			PreparedStatement psD = con.prepareStatement("Delete from Product where id=?");
			psD.setInt(1, Integer.parseInt(id));

			int deleted = psD.executeUpdate();
			if (deleted > 0) {
		out.println("Delete Successfully!");
			} else {
		out.println("Didn't delete!");
			}
			psD.close();
			break;

		default:
			out.println("Invalid action");
		}
		con.close();
	} catch (Exception e) {
		out.println(e.getMessage());
	}
	%>
</body>
</html>