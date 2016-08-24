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

	<form:form class="form-horizontal" method="post" commandName="product" enctype="multipart/form-data">
                
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
		
		<spring:bind path="category">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Category</label>
			<div class="col-sm-10">
				<form:select path="category" type="text" class="selectpicker"  items="${categories}"
                                id="category" placeholder="Category" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="price">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Price</label>
			<div class="col-sm-10">
				<form:input path="price" class="form-control" id="price" />
				<form:errors path="price" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="image">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<div class="col-sm-10">
				    <label class="control-label">Select File</label>
	   				<form:input path = "image" name="image" type="file" class="file" id="image"/>
	   				<form:errors path="image" class="control-label" />
	   			</div>
		    </div>
		</spring:bind>
		
		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			<c:choose>
			  <c:when test="${product['new']}">
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