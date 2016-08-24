<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main page</title>
	 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
 
    <jsp:include page="WEB-INF/views/others/header.jsp" />
    
    <div class="main-container">
    	<div class="welcome-title ">Welcome to WebStore</div>
    	<br>
      <center><h3>Enjoy your shopping!</h3></center>
 	</div>
 	
    <jsp:include page="WEB-INF/views/others/footer.jsp" />
 
</body>
</html>