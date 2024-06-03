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

</head>
<body>
	<div class="container">

		<!-- Menu de l'application -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.request.contextPath}/admin/showExamenForm">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/showExamenForm">Add Exam
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/allExamens">All Exams
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
			<c:if test="${action=='admin/addExamen'}">
				<h3>New Examen</h3>
			</c:if>
			<c:if test="${action=='admin/updateExame'}">
				<h3>Update Examen</h3>
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
				<%--@elvariable id="examenModel" type="com"--%>
				<f:form action="${pageContext.request.contextPath}/admin/${action}"
					method="POST" modelAttribute="examenModel">

					<div class="row">
						<f:input path="idExamen" type="hidden" />
						<div class="col">
							<label>Element Pedagogique</label>
							<f:select path="idMatiere" class="form-control">
								<c:forEach items="${matiereList}" var="m">
									<f:option value="${m.idElementPedagogique}">${m.titre}</f:option>
								</c:forEach>
							</f:select>
							<f:errors path="idMatiere" class="text-danger" />
						</div>

						<div class="col">
							<label>Semestre</label>
							<f:select path="semestre" class="form-control">
								<f:option value="S1">S1</f:option>
								<f:option value="S2">S2</f:option>
							</f:select>
							<f:errors path="semestre" class="text-danger" />
						</div>

						<div class="col">
							<label>Session</label>
							<f:select path="session" class="form-control">
								<f:option value="normale">normale</f:option>
								<f:option value="rattrapage">rattrapage</f:option>
							</f:select>
							<f:errors path="session" class="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col">
							<label>Type d'Examen</label>
							<f:select path="typeExamen" class="form-control" placeholder="Type">
								<f:option value="DS">DS</f:option>
								<f:option value="Examen Finale">Examen Finale</f:option>
							</f:select>
							<f:errors path="typeExamen" class="text-danger" />
						</div>

						<div class="col">
							<label>Date</label>
							<f:input path="dateExamen" type="date" class="form-control" required="required"/>
							<f:errors path="dateExamen" class="text-danger" />
						</div>

						<div class="col">
							<label>Heure de début</label>
							<f:input path="heureExamen" type="time" class="form-control" required="required"/>
							<f:errors path="heureExamen" class="text-danger" />
						</div>
					</div>

					<div class="text-right mt-3">
						<button type="submit" class="btn btn-primary">Next</button>
						<button type="reset" class="btn btn-secondary">Rest</button>
					</div>
				</f:form>
			</c:if>
			<c:if test="${showDureePrevueForm}">
				<%--@elvariable id="examenModel" type="com"--%>
				<f:form action="${pageContext.request.contextPath}/admin/${action}"
						method="POST" modelAttribute="examenModel">

					<div class="row">
						<f:input path="idExamen" type="hidden" />
						<div class="col">
							<label>Durée Prévue d'Examen</label>
							<f:input path="dureePrevue" type="number" step="any" class="form-control"
									 placeholder="Durée par heure" />
							<f:errors path="dureePrevue" class="text-danger" />
						</div>

						<div class="col">
							<label>Nombre de Salles</label>
							<f:input path="nombreSalle" type="number" inputmode="numeric" pattern="[0-9]*"
									 min="1" max="5" class="form-control"/>
							<f:errors path="nombreSalle" class="text-danger" />
						</div>

						<div class="col text-right mt-5">
							<button type="submit" class="btn btn-primary">Next</button>
							<button type="reset" class="btn btn-secondary">Rest</button>
						</div>
					</div>
				</f:form>
			</c:if>
			<c:if test="${showSurveillanceForm}">
				<c:forEach items="${reservationList}" var="rv">
					<f:form action="${pageContext.request.contextPath}/admin/${action}"
							method="POST" modelAttribute="rv">

						<div class="row">
							<div class="col">
								<label>Nombre de Surveillants</label>
								<f:input path="nombreSurveillants" type="number" inputmode="numeric" pattern="[0-9]*"
										 class="form-control"/>
								<f:errors path="nombreSurveillants" class="text-danger" />
							</div>

							<div class="col">
								<label>Nombre de Surveillants</label>
								<f:select path="nomSalle" class="form-control">
									<c:forEach items="${availableSalles}" var="salle">
										<f:option value="${salle.nomSalle}">${salle.nomSalle}</f:option>
									</c:forEach>
								</f:select>
								<f:errors path="nomSalle" class="text-danger" />
							</div>

							<div class="col text-right mt-5">
								<button type="submit" class="btn btn-primary">Next</button>
								<button type="reset" class="btn btn-secondary">Rest</button>
							</div>
						</div>
					</f:form>
				</c:forEach>
			</c:if>
		</div>

		<div>Spring Web App by Tarik BOUDAA, National School of Applied
			Science Al Hoceima
		</div>
	</div>
</body>
</html>