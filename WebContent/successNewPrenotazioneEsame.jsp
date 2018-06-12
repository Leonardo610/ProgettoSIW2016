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
					<li><a href="./info.jsp">Info</a></li>
					<li><a href="./contatti.jsp">Contatti</a></li>
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
	</div>
	
	                             <!-- NAVBAR END-->
	                             
		<div class="container">


			<f:view>
				<h1>Inserimento nuova Prenotazione Esame effettuata con successo!</h1>
				<br>
				<hr>
				<br>
				<h2>Dettagli</h2>
				<br>

				<table class="table">
					<thead>
						<tr>
							<th>Codice</th>
							<th>Cognome medico</th>
							<th>Tipologia</th>
							<th>Data di prenotazione</th>
							<th>Data visita</th>
							<th>Paziente</th>
						</tr>
					</thead>
					<tbody>
						<tr class="success">
							<td>${examController.exam.code}</td>
							<td>${examController.exam.medic.surname}</td>
							<td>${examController.exam.typology.name}</td>
							<td>${examController.exam.prenotationDate}</td>
							<td>${examController.exam.visitDate}</td>
							<td>${examController.exam.patient.name} ${examController.exam.patient.surname}</td>
						</tr>
					</tbody>
				</table>

				<br>
				<br>
				<div>
					<a href='<c:url value="./faces/newPrenotazioneEsame.jsp" />'>Continua
						ad inserire nuove <i>Prenotazioni Esami</i>
					</a>. <br> <a href='<c:url value="./faces/admin.jsp" />'>Concludi
						inserimento <i>Prenotazione Esami</i>
					</a>.
				</div>
			</f:view>


		<hr>

	</div>
	<!-- /container -->
</body>
</html>