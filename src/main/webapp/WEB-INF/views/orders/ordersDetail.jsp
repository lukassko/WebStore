<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Order informations</title>
</head>
<body>
	<h2>Client</h2>
	<table id="client" border=1>
		<tr>
			<th>ID</th>
			<td>${client.id}</td>
		</tr> 	
		<tr>
			<th>First name</th>
			<td>${client.name}</td>
		</tr> 
		<tr>
			<th>Last name</th>
			 <td>${client.lastName}</td>
		</tr> 
	</table>
	
	<h2>Orders</h2>
	
	<table id="orderList">
	<tr>
		<td>Date</td>
		<td>Total price</td>
	</tr> 
	<c:forEach var="order" items="${client.orders}">
	<tr>
		<td>${order.date}</td>
		<td>${order.totalPrice}</td>
	</tr> 
	</c:forEach>
	</table>
	
	
	<table id="productList">
	<tr>
		<td>Order ID</td>
		<td>Date</td>
		<td>Name</td>
	</tr> 
	<c:forEach var="order" items="${client.orders}">
		<c:forEach var="product" items="${order.products}">
		<tr>
			<td>${orders.id}</td>
			<td>${product.category.name}</td>
			<td>${product.name}</td>
		</tr> 
		</c:forEach>
	</c:forEach>
	</table>
	<br>
</body>
</html>