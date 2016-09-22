<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header-container">
	<div class="main-name"> Online Shop </div>
	<div id="log" class="log-info">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
           <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
	</div>
	
</div>
