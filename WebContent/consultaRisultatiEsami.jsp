<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="lib/css/index.css" rel="stylesheet">
<link href="lib/css/bootstrap.min.css" rel="stylesheet">
<link href="lib/css/ExamTypologiesTable.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="lib/js/ExamTypologiesTable.js"></script>





<title>ClinicaAcme</title>
<link rel="shortcut icon"
	href="./lib/resources/bastone_asclepio_ico.ico" />
</head>


<body>
	<f:view>
		<c:if test="${administratorController.administrator.username!=null}">
			<div>
				<h6 align="right">
					Sei loggato come ${administratorController.administrator.username}.
					<h:form>
						<h:commandLink value="Logout"
							action="#{administratorController.logout}" />
					</h:form>
				</h6>
			</div>
		</c:if>
	</f:view>

	                                <!-- NAVBAR -->
	                                
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">ClinicaAcme</h3>
			<span class="pull-right">

				<ul class="nav panel-tabs">
					<li class="active"><a href="./index.html">Home</a></li>
					<li><a href="./chiSiamo.jsp">Chi siamo</a></li>
					<li><a href="./tipologieEsami.jsp">Esami</a></li>
					<li><a href="./login.jsp">Area Utenti</a></li>
					<li><a href="info.jsp" data-toggle="tab">Info</a></li>
					<li><a href="contatti.jsp" data-toggle="tab">Contatti</a></li>
				</ul>
			</span>
		</div>
		<div class="panel-body">
			<div class="tab-content">
				<!--<div class="tab-pane active" id="tab1"></div> -->
				<div class="tab-pane" id="tab2"></div>
				<div class="tab-pane" id="tab3"></div>
				<div class="tab-pane" id="tab4"></div>
			</div>
		</div>

	                       	<!-- NAVBAR END-->
	                       	

		<h1>Benvenuto!</h1>
		<p>In questa sezione potrai consultare i risultati dei tuoi esami</p>

		<div class="container">

			<div class="row">
				<div class="col-md-8">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Esami Svolti</h3>
							<div class="pull-right">
								<span class="clickable filter" data-toggle="tooltip"
									title="Toggle table filter" data-container="body"> <i
									class="glyphicon glyphicon-filter"></i>
								</span>
							</div>
						</div>
						<div class="panel-body">
							<input type="text" class="form-control" id="dev-table-filter"
								data-action="filter" data-filters="#dev-table"
								placeholder="Filtro Esami" />
						</div>
						<f:view>
							<h:form>
								<table class="table table-hover" id="dev-table">
									<thead>
										<tr>
											<th>Esame</th>
											<th>Data</th>
											<th>Descrizione</th>
											<th>Prezzo</th>
											<th>Pagina Risultati</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="exam" items="#{examController.patientExams}">
											<tr class="info">
												<td>${exam.code}</td>
												<td>${exam.visitDate}</td>
												<td>${exam.description}</td>
                                                 <td>${exam.price}</td>
												<td><h:commandLink
														action="#{examController.findExamResults}"
														value="Risultati">
														<f:param name="id" value="#{exam.id}" />
													</h:commandLink></td>

											</tr>
										</c:forEach>

									</tbody>
								</table>
							</h:form>
						</f:view>
					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>