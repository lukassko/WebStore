<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main page</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<%@ page isELIgnored="false" %>
</head>
<body>
 
    <jsp:include page="header.jsp" />
    
    <div class="main-container">
    	<div class="welcome-title ">Welcome to WebStore</div>
    	<br>
      <center><h3>Enjoy your shopping!</h3></center>
 	</div>
 	
    <jsp:include page="footer.jsp" />
 
</body>
</html>