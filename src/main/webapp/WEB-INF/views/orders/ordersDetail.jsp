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
		<!-- wyswietlenei produktow
			<td colspan="2">
			<table>
			<c:forEach var="visit" items="${pet.visits}">
			<tr>
				<td>${visit.date}</td>
				<td>${visit.description}</td>
			</tr>
			</c:forEach>
			</table>
			</td>
		 -->
	</tr> 
	</c:forEach>
	</table>
	<br>
</body>
</html>