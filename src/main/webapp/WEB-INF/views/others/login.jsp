<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Login</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
    
    <div class = "main-body">
		<form  method="POST" action="${pageContext.request.contextPath}/j_spring_security_check">
	                
			<label>Email</label>
			<input type="text" name="j_username" id="email" placeholder="Email" require>
	
			<label>Password</label>
			<input type="password" name="j_password" id="password" placeholder="Password" require>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Login">
		</form>
	</div>
 	
 
</body>
</html>