<%@ page import="com.example.demo.entity.Student"%>
<%@ page import="java.util.List"%>

<html>
<head>
<title>Student List</title>
</head>
<body>

	<h2>Student List</h2>
	<a href="/add">
		<button type="button">Add New Student</button>
	</a>
	<br>
	<br>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Marks</th>
			<th>Actions</th>
		</tr>

		<%
		List list = (List) request.getAttribute("list");
		for (Object o : list) {
			Student s = (Student) o;
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getMarks()%></td>

			<!-- Edit / Delete buttons -->
			<td><a href="/delete/<%=s.getId()%>"
				onclick="return confirm('Are you sure?')">
					<button>Delete</button>
			</a></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>