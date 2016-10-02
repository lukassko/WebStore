<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="javascript"> 

	function postMethod() {
	    var form = document.createElement("form");
	    var path = "${pageContext.request.contextPath}/logout"
	    form.setAttribute("method", "post");
	    form.setAttribute("action", path);
	    
	    var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "${_csrf.parameterName}");
        hiddenField.setAttribute("value", "${_csrf.token}");
        form.appendChild(hiddenField);
        
	    document.body.appendChild(form);
	    form.submit();
	}
</script>
<div class="header-container">
	<div class="main-name"> Online Shop </div>
	<div id="log" class="log-info">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		   <a id="myLink" href="#" onclick="postMethod();">Logout</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
           <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
	</div>
	
</div>
