<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Personnel Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<style>
h3 {
	margin-top: 20px;
}

#navbarNav div {
	height: 0;
}

#navbarNav form {
	margin: 0;
	padding: 0;
}

form {
	margin-bottom: 60px;
	margin-top: 10px;
	padding: 10px;
}
</style>

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
						href="${pageContext.request.contextPath}/admin/showForm">Add Personnel
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/allPersonnels">All
							Personnels </a></li>
					<li class="nav-item"><form
							action="${pageContext.request.contextPath}/admin/serachPersonnel"
							class="d-flex" method="POST">
							<input name="keyword" class="form-control me-2" type="search"
								placeholder="First name" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form></li>
				</ul>
			</div>
		</nav>
		<!-- End Menu de l'application -->

		<div>
			<c:if test="${action=='admin/addPersonnel'}">
				<h3>New Personnel</h3>
			</c:if>
			<c:if test="${action=='admin/updatePersonnel'}">
				<h3>Update Personnel</h3>
			</c:if>
		</div>

		<div>
			<c:if test="${infoMsg!=null}">
				<div class="alert alert-success" role="alert">${infoMsg}</div>
			</c:if>
			<c:if test="${errorMsg!=null}">
				<div class="alert alert-danger" role="alert">${errorMsg}</div>
			</c:if>

			<c:if test="${showForm}">
				<f:form action="${pageContext.request.contextPath}/admin/${action}"
					method="POST" modelAttribute="personnelModel">

					<div class="row">
						<f:input path="idPersonnel" type="hidden" />
						<div class="col">
							<label>First Name</label>
							<f:input path="prenom" type="text" class="form-control"
								placeholder="First Name" />
							<f:errors path="prenom" class="text-danger" />
						</div>

						<div class="col">
							<label>Last Name</label>
							<f:input path="nom" type="text" class="form-control"
								placeholder="Last Name" />
							<f:errors path="nom" class="text-danger" />
						</div>
					</div>

					<div style="text-align: right">
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
<%--				<c:forEach items="${personnelList}" var="p">
						<tr>
							<td><c:out value="${p.prenom}" /></td>
							<td><c:out value="${p.nom}" /></td>
							<td><c:out value="${p.type}" /></td>
							<td>
								<ul>
									<li><a href="deletePersonnel/${p.idPersonnel}">Delete</a></li>
									<li><a href="updatePersonnel/${p.idPersonnel}">Update</a></li>
								</ul>
							</td>
						</tr>
					</c:forEach>--%>
				<c:forEach items="${enseignantList}" var="p">
					<tr>
						<td><c:out value="${p.prenom}" /></td>
						<td><c:out value="${p.nom}" /></td>
						<td><c:out value="Enseignant" /></td>
						<td>
							<ul>
								<li><a href="deletePersonnel/${p.idPersonnel}">Delete</a></li>
								<li><a href="updatePersonnel/${p.idPersonnel}">Update</a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
				<c:forEach items="${administrateurList}" var="p">
					<tr>
						<td><c:out value="${p.prenom}" /></td>
						<td><c:out value="${p.nom}" /></td>
						<td><c:out value="Administrateur" /></td>
						<td>
							<ul>
								<li><a href="deletePersonnel/${p.idPersonnel}">Delete</a></li>
								<li><a href="updatePersonnel/${p.idPersonnel}">Update</a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>Spring Web App by Tarik BOUDAA, National School of Applied
			Science Al Hoceima
		</div>
	</div>
</body>
</html>