<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add new product</title>
</head>
<body>
	<a href="index.jsp">Home</a>
	<h2>Add New Product</h2>
	<form action="ProductsController" method="post" name="frmAddUser">
		<div>
			<label>Id :</label>
			<input type="text" name="id" readonly="readonly" value="<c:out value="${products.id}"/>"/>
		</div><br><br>
		<div>
			<label>Name :</label>
			<input type="text" name="name" value="<c:out value="${products.name}"/>"/>
		</div><br><br>
		<div>
			<label>Price :</label>
			<input type="text" name="price" value="<c:out value="${products.price}"/>"/>
		</div><br><br>
		<div>
			<label>Brand :</label>
			<input type="text" name="brand" value='<c:out value="${products.brand}"/>'/>
		</div><br><br>
		<input type="submit" value="Add Product"/>
	</form>
</body>
</html>