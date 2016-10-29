<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Order informations</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	 <script type="text/javascript">
	 
	 function ajaxCall() {
		 var xmlhttp = new XMLHttpRequest();
		 
		 var searchString = document.getElementById("searchByString").value;
	     var tmp = document.getElementById("category");
	     var category = tmp.options[tmp.selectedIndex].value;
	     var ajaxUrl = "${pageContext.request.contextPath}/searchProductBy?category=" + category + "&searchString=" + searchString;

		 xmlhttp.onreadystatechange = function() {
			 var xmlStatus = xmlhttp.status
		     if (xmlhttp.readyState == XMLHttpRequest.DONE ) {
		        if (xmlStatus == 200) {
		        	renderView(xmlhttp.responseText);
		        }
		        else {
		        	badAjaxResponse(xmlStatus);
		        }
		     }
		 };
		 xmlhttp.open("GET", ajaxUrl, true);
		 xmlhttp.send();
	}
	
	 function renderView (response) {
		 document.getElementById('productsList').innerHTML=response;  
	 }
	 
	 function badAjaxResponse(status) {
		 console.log(status);
	 }
	 </script> 
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
  
  	<div class="help-panel">
	  	<div class="help-panel-member">
	  		<label>Sort by:</label>
	  		 <select id="category" style="width: 200px; padding:4px;margin:0;" type="text" name="search" placeholder="Search..">
			  <option value="category">Category</option>
			  <option value="name">Name</option>
			</select>
		</div>
		<div class="help-panel-member">
	  		<label>Search: </label>  
	  		 <input id="searchByString" style="width: 200px; padding:4px;margin:0;" type="text" name="search" placeholder="Search..">
		</div>
		<div class="help-panel-member">
			<button type="button" class="find-button" onclick="ajaxCall()">Find</button> 
		</div>
  	</div>
	<div id="productsList" class = "main-body">
      <table class="gridtable" >
		<thead>
           <tr>
              <th>Category</th>
              <th>Name</th>
              <th>Price</th>
              <th>Image</th>
              <th>Action</th>
           </tr>
		</thead>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.category.name}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>
				 <img src="${pageContext.request.contextPath}/productImage?code=${product.id}" 
    	 				width="100" height="80">
				</td>
				<td>
					<security:authorize  access="hasRole('ROLE_ADMIN')">
						<a class="button edit-button" href="${pageContext.request.contextPath}/products/edit?id=${product.id}">Edit client</a>
					</security:authorize>
					<security:authorize  access="hasRole('ROLE_USER')">
						<a class="button new-button" href="${pageContext.request.contextPath}/addProductToCart?id=${product.id}">Buy</a>
					</security:authorize>
				</td>
			</tr> 
		</c:forEach> 
	</table>
	</div>
   <jsp:include page="../others/footer.jsp" />
</body>
</html>