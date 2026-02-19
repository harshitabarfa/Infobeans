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
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch14", "root", "123456");

		String id = request.getParameter("ID");
		String title = request.getParameter("Title");
		String author = request.getParameter("Author");
		String price = request.getParameter("Price");
		String year = request.getParameter("Year");
		String action = request.getParameter("action");

		switch (action) {

		case "insert":
			if (id == null || id.isEmpty() || price == null || price.isEmpty() || year == null || year.isEmpty()) {
		out.println("<h3 style='color:red'>Please fill all numeric fields!</h3>");
		return;
			}

			int idVal = Integer.parseInt(id);
			double priceVal = Double.parseDouble(price);
			int yearVal = Integer.parseInt(year);

			PreparedStatement ps = con
			.prepareStatement("INSERT INTO Boook (id,title,author,price,year) VALUES (?,?,?,?,?)");
			ps.setInt(1, idVal);
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setDouble(4, priceVal);
			ps.setInt(5, yearVal);

			ps.executeUpdate();
			out.println("<h2>Insert successfully!</h2>");
			ps.close();
			break;

		case "view":
			PreparedStatement psV = con.prepareStatement("SELECT * FROM Boook");
			ResultSet rs = psV.executeQuery();

			out.println("<h3>All Books:</h3>");
			out.println("<table border='1'>");
			out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Year</th></tr>");
			while (rs.next()) {
		out.println("<tr>");
		out.println("<td>" + rs.getInt("id") + "</td>");
		out.println("<td>" + rs.getString("title") + "</td>");
		out.println("<td>" + rs.getString("author") + "</td>");
		out.println("<td>" + rs.getDouble("price") + "</td>");
		out.println("<td>" + rs.getInt("year") + "</td>");
		out.println("</tr>");
			}
			out.println("</table>");
			rs.close();
			psV.close();
			break;

		case "update":
			if (id == null || id.isEmpty() || price == null || price.isEmpty() || year == null || year.isEmpty()) {
		out.println("<h3 style='color:red'>Please fill all numeric fields!</h3>");
		return;
			}

			int idUp = Integer.parseInt(id);
			double priceUp = Double.parseDouble(price);
			int yearUp = Integer.parseInt(year);

			PreparedStatement psU = con
			.prepareStatement("UPDATE Boook SET title = ?, author = ?, price = ?, year = ? WHERE id = ?");
			psU.setString(1, title);
			psU.setString(2, author);
			psU.setDouble(3, priceUp);
			psU.setInt(4, yearUp);
			psU.setInt(5, idUp);

			int updated = psU.executeUpdate();
			if (updated > 0) {
		out.println("<h3>Updated successfully!</h3>");
			} else {
		out.println("<h3>Book not found!</h3>");
			}
			psU.close();
			break;

		case "delete":
			if (id == null || id.isEmpty()) {
		out.println("<h3 style='color:red'>Please enter ID to delete!</h3>");
		return;
			}

			int idDel = Integer.parseInt(id);
			PreparedStatement psD = con.prepareStatement("DELETE FROM Boook WHERE id=?");
			psD.setInt(1, idDel);

			int deleted = psD.executeUpdate();
			if (deleted > 0) {
		out.println("<h3>Delete Successfully!</h3>");
			} else {
		out.println("<h3>Book not found!</h3>");
			}
			psD.close();
			break;

		default:
			out.println("<h3>Invalid action</h3>");
		}

		con.close();
	} catch (Exception e) {
		out.println("<h3 style='color:red'>" + e.getMessage() + "</h3>");
	}
	%>
</body>
</html>