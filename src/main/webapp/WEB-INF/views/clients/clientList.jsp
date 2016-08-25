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
    	<div class="additional-action"> Add new client </div>
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
				<spring:url value="${pageContext.request.contextPath}/clients/${client.id}/orders" var="clientUrl" />
				<spring:url value="${pageContext.request.contextPath}/clients/${client.id}/edit" var="editUrl" />
				<spring:url value="${pageContext.request.contextPath}/clients/${client.id}/delete" var="deleteUrl" /> 
							    
				<button class="btn btn-info"  onclick="location.href='${clientUrl}'">Orders</button>
				<button class="btn btn-primary"  onclick="location.href='${editUrl}'">Edit</button>
				<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
				</td>
			</tr>
		</c:forEach>	     
	</table>
  </div>
  <jsp:include page="../others/footer.jsp" />
</body>
</html>