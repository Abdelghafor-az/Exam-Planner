<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
	<title>Element Pedagogique Management</title>
	<link rel="stylesheet" href="/src/main/webapp/resources/css/custom.css" type="text/css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	<!-- Include Twitter Bootstrap and jQuery: -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" type="text/css" />
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- Include the plugin's CSS and JS: -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css" type="text/css" />

</head>
<body>
	<div class="container">

		<!-- Menu de l'application -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.request.contextPath}/admin/showForm">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/showElementForm">Add Exam
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/allElements">All Exams
					</a></li>
					<li class="nav-item">
						<form action="${pageContext.request.contextPath}/admin/searchPersonnel"
							class="d-flex" method="POST">
							<input name="keyword" class="form-control me-2" type="search"
								placeholder="First name" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
					</li>
				</ul>
			</div>
		</nav>
		<!-- End Menu de l'application -->

		<div>
			<c:if test="${action=='admin/addElement'}">
				<h3>New Element Pedagogique</h3>
			</c:if>
			<c:if test="${action=='admin/updateElement'}">
				<h3>Update Element Pedagogique</h3>
			</c:if>
		</div>

		<div>
			<c:if test="${infoMsg!=null}">
				<div class="alert alert-success" role="alert">${infoMsg}</div>
			</c:if>
			<c:if test="${errorMsg!=null}">
				<div class="alert alert-danger" role="alert">${errorMsg}</div>
			</c:if>

			<c:if test="${showExamenForm}">
				<%--@elvariable id="elementModel" type="com"--%>
				<f:form action="${pageContext.request.contextPath}/admin/${action}"
					method="POST" modelAttribute="elementModel">

					<div class="row">
						<f:input path="idElementPedagogique" type="hidden" />
						<div class="col">
							<label>Element Pedagogique Title</label>
							<f:input path="title" type="text" class="form-control"
								placeholder="Title" />
							<f:errors path="prenom" class="text-danger" />
						</div>

						<div class="col">
							<label>Type</label>
							<f:input path="nom" type="text" class="form-control"
								placeholder="Last Name" />
							<f:errors path="nom" class="text-danger" />
						</div>

						<c:if test="${action=='addPersonnel'}">
							<div class="col">
								<label>Type</label>
								<f:select path="type" class="form-control" placeholder="Type">
									<f:option value="Enseignant">Enseignant</f:option>
									<f:option value="Administrateur">Administrateur</f:option>
								</f:select>
								<f:errors path="type" class="text-danger" />
							</div>
						</c:if>
					</div>

					<div class="text-right mt-3">
						<button type="submit" class="btn btn-primary">Send</button>
						<button type="reset" class="btn btn-secondary">Rest</button>
					</div>
				</f:form>
			</c:if>
		</div>

		<div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Type</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${examenList}" var="ex">
					<tr>
						<td><c:out value="${ex.nomGroupe}" /></td>
						<td><c:out value="-----" /></td>
						<td><c:out value="Groupe" /></td>
						<td>
							<ul>
								<li><a href="deleteGroupe/${ex.idExamen}">Delete</a></li>
								<li><a href="updateGroupe/${ex.idExamen}">Update</a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div>Spring Web App by Tarik BOUDAA, National School of Applied
			Science Al Hoceima
		</div>
	</div>
	<!-- Initialize the plugin: -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example-multiple-selected').multiselect();
		});
	</script>
</body>
</html>