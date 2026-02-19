<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
</head>
<body>
	<div class="container">
		<h1>Employee Management</h1>
		<form action="employeeOperations.jsp" method="post">
			<label for="empId">Employee ID</label> <input type="number"
				name="empId" id="empId"><br> <br> <label
				for="name">Name</label> <input type="text" name="name" id="name"><br>
			<br> <label for="designation">Designation</label> <input
				type="text" name="designation" id="designation"><br> <br>
			<label for="salary">Salary</label> <input type="number" step="0.01"
				name="salary" id="salary"><br> <br> <label
				for="department">Department</label> <input type="text"
				name="department" id="department"><br> <br>

			<div class="button-group">
				<input type="submit" name="action" value="insert"> <input
					type="submit" name="action" value="update"> <input
					type="submit" name="action" value="view"> <input
					type="submit" name="action" value="delete">
			</div>
		</form>
	</div>
</body>
</html>
