<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>My Cart</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <spring:url value="/" var="urlHome" />
	<spring:url value="/clients/new" var="urlAddUser" />
	
	<nav class="navbar navbar-inverse ">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${urlHome}">Main</a>
			</div>
			<div id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${urlAddUser}">Add Client</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
</head>
<body>

<div class="container">
	<h2>Shopping Cart</h2>
	
	<table class="table table-striped">
				<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				</thead>
					<c:forEach var="product" items="${products}">
						<tr>
							<td>${product.name}</td>
							<td>${product.price}</td>
						</tr>
					</c:forEach>	     
			</table>
			
	<spring:url value="/clients/${client.id}/orders/new/showProducts" var="productUrl" />
							    
	<button class="btn btn-info"  onclick="location.href='${productUrl}'">Show product</button>

</div>
</body>
</html>