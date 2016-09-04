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
		<form  method="get" action="${pageContext.request.contextPath}/clients">
	                
			<label>Email</label>
			<input type="text" name="email" id="email" placeholder="Email" require>
	
			<label>Password</label>
			<input name="password"  type="password" id="password" placeholder="Password" require>
	
			<input type="submit" value="Login">
		</form>
	</div>
 	
 
</body>
</html>