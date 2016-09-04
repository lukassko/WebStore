<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Order informations</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

	<c:if test="${not empty msg}">
	    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
	                                aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			    </div>
		</c:if>
		
	<jsp:include page="../others/header.jsp" />
	<div class="title-container">
      	<div class="page-title ">Client detail</div>
    	<div class="additional-action">${client.name}  ${client.lastName}</div>
    	
  	</div>
  
	<div class = "main-body">
	
      <table class="gridtable" >
		<thead>
           <tr>
              <th>Order ID</th>
              <th>Date</th>
              <th>Total price</th>
              <th>Action</th>
           </tr>
		</thead>
		<c:forEach var="order" items="${orders.resultList}">
			<tr>
				<td>${order.id}</td>
				<td>${order.date}</td>
				<td>${order.totalPrice}</td>
				<td><a class="button edit-button">Show detail</a></td>
			</tr> 
		</c:forEach>
		<c:if test="${fn:length(orders.resultList)==0}">
		   <tr class="emptyRow">
				<td colspan="4">
					<label>Empty list</label>
				</td>
			</tr> 
		</c:if>     
	</table>
	
	<c:if test="${orders.totalPages > 1}">
        <div class="page-navigator">
           <c:forEach items="${orders.navigationPage}" var = "page">
           <%System.out.println(page);%>
               <c:if test="${page != -1 }">
                 <a href="${pageContext.request.contextPath}/clients/${client.id}/orders?page=${page}">${page}</a>
               </c:if>
               <c:if test="${page == -1 }">
                 <span> ... </span>
               </c:if>
           </c:forEach>
            
        </div>
    </c:if>
    
	<!--  <div style="display:inline-block;float:left;">-->

		<span class="page-title ">Orders detail</span>
		<div align="right"><a class="button new-button" 
					href="${pageContext.request.contextPath}/clients/${client.id}/orders/new/shoppingCart">New order</a>
					</div>	
	<hr>
	
		<table class="gridtable" >
			<thead>	
				<tr>
					<th>Order Id</th>
					<th>Category</th>
					<th>Name</th>
					<th>Price</th>
				</tr> 
			</thead>
		<c:forEach var="order" items="${orders.resultList}">
			
			<tr>
				<c:set var="product_no" value="${fn:length(order.products)+1}" />
				
				<td rowspan="${product_no}">${order.id}</td>
				<c:forEach var="product" items="${order.products}">
					<tr>
						<td>${product.category.name}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
					</tr>
				</c:forEach>
			</tr> 
			</c:forEach>
			<c:if test="${fn:length(orders.resultList)==0}">
			   <tr class="emptyRow">
					<td colspan="4">
						<label>Empty list</label>
					</td>
				</tr> 
			</c:if>
		</table>
		<br>
		
		
	</div>
  <jsp:include page="../others/footer.jsp" />
</body>
</html>