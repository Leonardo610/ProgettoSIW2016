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

                          <!-- NAVBAR -->
                          
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">ClinicaAcme</h3>
			<span class="pull-right">

				<ul class="nav panel-tabs">
					<li class="active"><a href="./index.html">Home</a></li>
					<li><a href="./chiSiamo.jsp">Chi siamo</a></li>
					<li><a href="./tipologieEsami.jsp">Esami</a></li>
					<li><a href="./login.jsp">Area Utenti</a></li>
					<li><a href="#tab4" data-toggle="tab">Info</a></li>
					<li><a href="#tab5" data-toggle="tab">Contatti</a></li>
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

		<div class="container">

                                 <!-- NAVBAR END-->
                                 
                                 
			<f:view>

				<h1>Impossibile inserire il nuovo Medico.</h1>
				<br>
				<h2>Medico con questo codice gia' presente.</h2>
				<hr>
				<br>

				<h:form>
					<table class="table">
						<thead>
							<tr>
								<th>Codice</th>
								<th>Nome</th>
								<th>Cognome</th>
								<th>Specializzazione</th>
							</tr>
						</thead>
						<tbody>
							<tr class="danger">
								<td><span style="text-decoration: line-through;">${medicController.medic.code}</span></td>
								<td>${medicController.medic.name}</td>
								<td>${medicController.medic.surname}</td>
								<td>${medicController.medic.specialization.name}</td>
							</tr>
						</tbody>
					</table>
				</h:form>

				<br>
				<br>
				<div>
					<a href='<c:url value="/faces/newMedico.jsp" />'>Torna ad
						inserire un nuovo <i>Medico</i>
					</a>.
				</div>
			</f:view>


			<hr>


		</div>
		<!-- /container -->


	</div>
</body>
</html>