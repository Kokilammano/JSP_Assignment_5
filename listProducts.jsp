<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR">
<title>Show All Products</title>
</head>
<body>
	<h1>Product List</h1>
	<table border=2>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PRICE</th>
				<th>BRAND</th>
				<th colspan=2>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${prodt}" var="products">
				<tr>
					<td><c:out value="${products.id}"/></td>
					<td><c:out value="${products.name}"/></td>
					<td><c:out value="${products.price}"/></td>
					<td><c:out value="${products.brand}"/></td>
					<td><a href="ProductsController?action=edit&id=<c:out value="${products.id}"/>">Update</a></td>
					<td><a href="ProductsController?action=delete&id=<c:out value="${products.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>					
		</tbody>
	</table>
	<p><a href="ProductsController?action=insert">Add Products</a></p>
</body>
</html>