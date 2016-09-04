<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Client list</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<%@ page isELIgnored="false" %>

</head>
<body>
	<jsp:include page="../others/header.jsp" />
	<div class="title-container">
      	<div class="page-title ">Client List</div>
    	<a class="additional-action" href="${pageContext.request.contextPath}/clients/new"> Add new client </a>
  </div>
  <div class = "main-body">
      <table class="gridtable" >
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
				<a class="button new-button" href="${pageContext.request.contextPath}/clients/${client.id}/orders">Orders</a>
				<a class="button edit-button" href="${pageContext.request.contextPath}/clients/${client.id}/edit">Edit client</a>
				<a class="button delete-button" href="${pageContext.request.contextPath}/clients/${client.id}/delete">Delete client</a>
				</td>
			</tr>
		</c:forEach>	     
	</table>
  </div>
  <jsp:include page="../others/footer.jsp" />
</body>
</html>