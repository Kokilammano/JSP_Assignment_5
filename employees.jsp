<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add new employee</title>
</head>
<body>
	<a href="index.jsp">Home</a>
	<h2>Add New Employee</h2>
	<form action="EmployeeController" method="post" name="frmAddUser">
		<div>
			<label>Id :</label>
			<input type="text" name="id" readonly="readonly" value="<c:out value="${employe.id}"/>"/>
		</div><br><br>
		<div>
			<label>First Name :</label>
			<input type="text" name="fname" value="<c:out value="${employe.fname}"/>"/>
		</div><br><br>
		<div>
			<label>Last Name :</label>
			<input type="text" name="lname" value="<c:out value="${employe.lname}"/>"/>
		</div><br><br>
		<div>
			<label>Email :</label>
			<input type="email" name="email" value='<c:out value="${employe.email}"/>'/>
		</div><br><br>
		<div>
			<label>Mobile :</label>
			<input type="number" name="mobile" value='<c:out value="${employe.mobile}"/>'/>
		</div><br><br>
		<input type="submit" value="Add Employee"/>
	</form>
</body>
</html>