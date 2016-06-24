<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Order informations</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<c:if test="${not empty msg}">
	    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
	                                aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			    </div>
		</c:if>


	<h2>Client</h2>
	
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${client.id}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${client.name}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${client.lastName}</div>
	</div>
	
	
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
		<td>Category</td>
		<td>Name</td>
		<td>Price</td>
	</tr> 
	<c:forEach var="order" items="${client.orders}">
		<c:forEach var="product" items="${order.products}">
		<tr>
			<td>${order.id}</td>
			<td>${product.category.name}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
		</tr> 
		</c:forEach>
	</c:forEach>
	</table>
	<br>
	<spring:url value="/clients/${client.id}/orders/new/shoppingCart" var="newOrderUrl" />
	<button class="btn btn-info"  onclick="location.href='${newOrderUrl}'">New order</button>
</div>
</body>
</html>