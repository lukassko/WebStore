<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Products</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    
    <spring:url value="/" var="urlHome" />
	<spring:url value="/clients/new" var="urlAddUser" />
	
</head>
<body>

<div class="container">
  <div class="jumbotron">
    <h1><center>Select product</center><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></h1>

  </div>
<nav>
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<c:forEach var="product" items="${products}">
  <div class="row">
    <div class="col-sm-2">
      <h3>${product.category.name}</h3>
    </div>
    <div class="col-sm-2">
      <p>Title: ${product.name}</p>
      <p>Price: ${product.price}</p>
    </div>
    <div class="col-sm-2">
    	 <img src="${pageContext.request.contextPath}/productImage?code=${product.id}" 
    	 		class="img-rounded" alt="Cinque Terre" width="304" height="236">
    </div>
    <div class="col-sm-2">
      <button type="button" class="btn btn-default btn-lg" 
      		  onclick="location.href='/WebStore/addProductToCart?id=${product.id}'">
       <span class="glyphicon glyphicon-usd" aria-hidden="true"></span> Buy
     </button>
    </div>
  </div>
  </c:forEach>
</div>

</body>
</html>