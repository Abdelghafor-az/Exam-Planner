<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<title>Exam Planning</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
		crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<ul>
			<li><a href="${pageContext.request.contextPath}/admin/showForm">Gestion des Personnels</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/showElementForm">Gestion des Elements Pedagogiques</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/showExamenForm">Gestion des Examens</a></li>
		</ul>
	</div>
</body>
</html>