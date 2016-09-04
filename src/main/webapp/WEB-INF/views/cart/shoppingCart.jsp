<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>My Cart</title>
   	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="../others/header.jsp" />

	<div class="title-container">
      	<div class="page-title ">Shopping list</div>
      	<a class="additional-action" href="${pageContext.request.contextPath}/clients/${client.id}/orders/new/showProducts">Show product</a>
  </div>
  <div class = "main-body">
  	<table class="gridtable" >
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
		<c:if test="${fn:length(products)>0}">
		   <tr class ="noBorder">
				<td colspan="2">
					<a class="cell-button" 
						href="${pageContext.request.contextPath}/clients/${client.id}/orders/new/acceptOrder">Buy</a>
				</td>
			</tr> 
		</c:if>
		<c:if test="${fn:length(products)==0}">
		   <tr class="emptyRow">
				<td colspan="2">
					<label>Empty list</label>
				</td>
			</tr> 
		</c:if>
		
		</table>
		
  </div>
  <jsp:include page="../others/footer.jsp" />
</body>
</html>