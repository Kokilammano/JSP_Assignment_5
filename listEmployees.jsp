<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR">
<title>Show All Employees</title>
</head>
<body>
	<h1>Employee List</h1>
	<table border=2>
		<thead>
			<tr>
				<th>ID</th>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>EMAIL</th>
				<th>MOBILE</th>
				<th colspan=2>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${emp}" var="employe">
				<tr>
					<td><c:out value="${employe.id}"/></td>
					<td><c:out value="${employe.fname}"/></td>
					<td><c:out value="${employe.lname}"/></td>
					<td><c:out value="${employe.email}"/></td>
					<td><c:out value="${employe.mobile}"/></td>
					<td><a href="EmployeeController?action=edit&id=<c:out value="${employe.id}"/>">Update</a></td>
					<td><a href="EmployeeController?action=delete&id=<c:out value="${employe.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>					
		</tbody>
	</table>
	<p><a href="EmployeeController?action=insert">Add Employee</a></p>
</body>
</html>