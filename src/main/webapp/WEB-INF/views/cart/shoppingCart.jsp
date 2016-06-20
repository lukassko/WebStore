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
	<h2>Client List</h2>
		
			<table class="table table-striped">
				<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				</thead>
					<c:forEach var="client" items="${clients}">
						<tr>
							<td>${client.id}</td>
							<td>${client.name}</td>
							<td>${client.lastName}</td>
							<td>${client.email}</td>
							<td>
							    <spring:url value="/products/show" var="productUrl" />
							    
							    <button class="btn btn-info"  onclick="location.href='${productUrl}'">Show product</button>
							    
							 </td>
						</tr>
					</c:forEach>	     
			</table>
		</div>
</body>
</html>