<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Client detail</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../others/header.jsp" />
    
    <div class="title-container">
	    <div class="page-title ">
	    	<c:choose>
				<c:when test="${client['new']}">
					Add User
				</c:when>
				<c:otherwise>
					Update User
			</c:otherwise>
		</c:choose>
		</div>
    </div>
    <div class = "main-body">
	<form:form  method="post" commandName="client">
                
        <form:hidden path="id" />
        
        <spring:bind path="name">
			<label>Name</label>
			<form:input path="name" type="text" id="name" placeholder="Name" />
			<form:errors path="name"/>
		</spring:bind>
		
		<spring:bind path="name">
		  <!--   <div class="form-group ${status.error ? 'has-error' : ''}">-->
			<label>Last Name</label>
			<form:input path="lastName" type="text" id="lastName" placeholder="Last name" />
			<form:errors path="lastName"/>

		</spring:bind>
		
		
		<spring:bind path="email">
			<label>Email</label>
			<form:input type="text" path="email" id="email" placeholder="Email" />
			<form:errors path="email" class="control-label" />
		</spring:bind>
		
		<spring:bind path="password">
			<label>Password</label>

			<form:password path="password"  id="password" placeholder="password" />
			<form:errors path="password" class="control-label" />

		</spring:bind>
		
			<c:choose>
			  <c:when test="${client['new']}">
			     <input type="submit" value="Add">
			  </c:when>
			  <c:otherwise>
			     <input type="submit" value="Update">
			  </c:otherwise>
			</c:choose>
	</form:form>
	</div>
 	
    <jsp:include page="../others/footer.jsp" />
 
</body>
</html>