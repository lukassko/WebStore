<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Product detail</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>

<body>
	<jsp:include page="../others/header.jsp" />
    
    <div class="title-container">
	    <div class="page-title ">
	    	<c:choose>
				<c:when test="${product['new']}">
					Add product
				</c:when>
				<c:otherwise>
					Update product
			</c:otherwise>
		</c:choose>
		</div>
    </div>
    
    
    <div class = "main-body">

	<form:form class="form-horizontal" method="post" commandName="product" 
			 enctype="multipart/form-data">
		
		<form:hidden path="id" />
        
        <spring:bind path="name">
			<label>Name</label>
			<form:input path="name" type="text" id="name" placeholder="Name" />
			<form:errors path="name"/>
		</spring:bind>
		
		<spring:bind path="category">
			<label>Category</label>
			<br>
			<form:select path="category" type="text"  items="${categories}" id="category" placeholder="Category" />
			<form:errors path="category"/>
		</spring:bind>
		<br>
		<spring:bind path="price">
			<label>Price</label>
			<form:input path="price" type="text" id="price" placeholder="Price" />
			<form:errors path="price"/>
		</spring:bind>
		
		<spring:bind path="image">	
			<label>Image</label><br>
			<form:input path="image" type="file" id="image" placeholder="Image" />	
		</spring:bind>
		<br><br>
		<input type="submit" value="Add">	

	</form:form>
	
	
	
	</div>
 	
    <jsp:include page="../others/footer.jsp" />
 
</body>
</html>