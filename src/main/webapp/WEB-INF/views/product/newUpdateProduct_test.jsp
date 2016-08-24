<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Product detail</title>
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${client['new']}">
			<h1>Add Product</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Product</h1>
		</c:otherwise>
	</c:choose>
	<br />



	<form method="POST" enctype="multipart/form-data" commandName="product" enctype="multipart/form-data">
		File to upload: <input type="file" name="image"><br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>

	</div>
</body>
</html>