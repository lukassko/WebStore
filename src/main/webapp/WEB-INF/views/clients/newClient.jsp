<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Client detail</title>
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<c:choose>
		<c:when test="${client['new']}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>
	<br />
	
	<spring:url value="/clients" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" commandName="client">
                
        <form:hidden path="id" />
        
        <spring:bind path="name">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<form:input path="name" type="text" class="form-control" 
                                id="name" placeholder="Name" />
				<form:errors path="name" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="name">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-10">
				<form:input path="lastName" type="text" class="form-control" 
                                id="lastName" placeholder="Last name" />
				<form:errors path="lastName" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		
		<spring:bind path="email">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" class="form-control" 
                                id="email" placeholder="Email" />
				<form:errors path="email" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="password">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<form:password path="password" class="form-control" 
                                id="password" placeholder="password" />
				<form:errors path="password" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			<c:choose>
			  <c:when test="${client['new']}">
			     <button type="submit" class="btn-lg btn-primary pull-right">Add
                             </button>
			  </c:when>
			  <c:otherwise>
			     <button type="submit" class="btn-lg btn-primary pull-right">Update
                             </button>
			  </c:otherwise>
			</c:choose>
		  </div>
		</div>
		
	</form:form>
	</div>
</body>
</html>