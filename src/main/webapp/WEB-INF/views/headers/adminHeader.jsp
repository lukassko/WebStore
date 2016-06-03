<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/" var="urlHome" />
<spring:url value="/clients/new" var="urlAddUser" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Main</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add Client</a></li>
			</ul>
		</div>
	</div>
</nav>