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
						href="${pageContext.request.contextPath}/admin/showElementForm">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/showElementForm">Add Element Pedagogique
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/allElements">All Element Pedagogiques
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

			<c:if test="${showElementForm}">
				<%--@elvariable id="elementModel" type="com"--%>
				<f:form action="${pageContext.request.contextPath}/admin/${action}"
					method="POST" modelAttribute="elementModel">

					<div class="row">
						<f:input path="idElement" type="hidden" />
						<div class="col">
							<label>Element Pedagogique Title</label>
							<f:input path="titre" type="text" class="form-control"
								placeholder="Title" />
							<f:errors path="titre" class="text-danger" />
						</div>

						<div class="col">
							<label>Type</label>
							<f:select path="type" class="form-control" placeholder="Type">
								<f:option value="Module">Module</f:option>
								<f:option value="Element">Element</f:option>
							</f:select>
							<f:errors path="type" class="text-danger" />
						</div>

						<div class="col">
							<label>Niveau</label>
							<f:select path="niveau" class="form-control" placeholder="Niveau">
								<f:option value="CP1">CP1</f:option>
								<f:option value="CP2">CP2</f:option>
								<f:option value="CI1">CI1</f:option>
								<f:option value="CI2">CI2</f:option>
								<f:option value="CI3">CI3</f:option>
							</f:select>
							<f:errors path="niveau" class="text-danger" />
						</div>
					</div>

					<div class="row mt-3">
						<div class="col">
							<label>Enseignant</label>
							<f:select path="enseignant" class="form-control" placeholder="Niveau">
								<c:forEach items="${enseignantList}" var="e">
									<c:choose>
										<c:when test="${elementModel.enseignant == e.idPersonnel}">
											<f:option value="${e.idPersonnel}" selected="true"><c:out value="${e.prenom} ${e.nom}" /></f:option>
										</c:when>
										<c:otherwise>
											<f:option value="${e.idPersonnel}"><c:out value="${e.prenom} ${e.nom}" /></f:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</f:select>
						</div>

						<div class="col">
							<label>Coordonnateur</label>
							<f:select path="coordonnateur" class="form-control" placeholder="Niveau">
								<c:forEach items="${enseignantList}" var="c">
									<c:choose>
										<c:when test="${elementModel.enseignant == c.idPersonnel}">
											<f:option value="${c.idPersonnel}" selected="true"><c:out value="${c.prenom} ${c.nom}" /></f:option>
										</c:when>
										<c:otherwise>
											<f:option value="${c.idPersonnel}"><c:out value="${c.prenom} ${c.nom}" /></f:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</f:select>
						</div>

						<div class="col">
							<div class="text-right mt-3">
								<button type="submit" class="btn btn-primary">Send</button>
								<button type="reset" class="btn btn-secondary">Rest</button>
							</div>
						</div>
					</div>
				</f:form>
			</c:if>
		</div>

		<div class="mt-5">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Titre</th>
						<th scope="col">Type</th>
						<th scope="col">Enseignant</th>
						<th scope="col">Coordonnateur</th>
						<th scope="col">Niveau</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${elementList}" var="el">
						<tr>
							<td><c:out value="${el.titre}" /></td>
							<td><c:out value="${el.type}" /></td>
							<td><c:out value="${el.enseignant.prenom} ${el.enseignant.nom}" /></td>
							<td><c:out value="${el.coordonnateur.prenom} ${el.coordonnateur.nom}" /></td>
							<td><c:out value="${el.niveau.nomNiveau}" /></td>
							<td>
								<ul>
									<li><a href="deleteElement/${el.idElementPedagogique}">Delete</a></li>
									<li><a href="updateElement/${el.idElementPedagogique}">Update</a></li>
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
		$('#example-single').multiselect();
		$('#example-single-selected').multiselect();
	</script>
</body>
</html>