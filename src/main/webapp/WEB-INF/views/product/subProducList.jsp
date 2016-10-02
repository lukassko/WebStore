<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<div class = "main-body">
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
					<a class="button new-button" href="${pageContext.request.contextPath}/addProductToCart?id=${product.id}">Buy</a>
				</td>
			</tr> 
		</c:forEach> 
	</table>
</div>