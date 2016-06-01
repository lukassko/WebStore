<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Client detail</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <jsp:include page="../headers/adminHeader.jsp" />
</head>
<body>

	<h2>Client List</h2>
		<div class="container">
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
							    <spring:url value="/clients/${client.id}" var="clientUrl" />
							    <spring:url value="/clients/${client.id}/edit" var="editUrl" />
							    <spring:url value="/clients/${client.id}/delete" var="deleteUrl" /> 
							    
							    <button class="btn btn-info"  onclick="location.href='${clientUrl}'">Orders</button>
							    <button class="btn btn-primary"  onclick="location.href='${editUrl}'">Edit</button>
							    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
							 </td>
						</tr>
					</c:forEach>	     
			</table>
		</div>
</body>
</html>