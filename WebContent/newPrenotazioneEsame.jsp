<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Prenota nuovo esame</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap core CSS -->
<link href="./lib/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="./lib/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Css for the template of navigation bar -->
<link href="./lib/css/index.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

                                    <!-- NAVBAR -->
                                    
                                    
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">ClinicaAcme</h3>
			<span class="pull-right">

				<ul class="nav panel-tabs">
					<li class="active"><a href="./index.html" data-toggle="tab">Home</a></li>
					<li><a href="./chiSiamo.jsp">Chi siamo</a></li>
					<li><a href="./tipologieEsami.jsp">Esami</a></li>
					<li><a href="./admin.jsp">Area Utenti</a></li>
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
		                        <!-- NAVBAR END -->
		                        
		                         
		<div class="container">
			<h1 align="center">Prenota un nuovo esame:</h1>
			<br>
			<hr>
			<br>
			<f:view>
				<h:form>
					<fieldset class="form-group">
						<label for="inputCode">Codice: </label>
						<h:inputText value="#{examController.code}"
							styleClass="form-control" required="true"
							requiredMessage="Codice obbligatorio" id="inputCode" />
						<h:message for="inputCode" />
						<br /> <label class="control-label" for="inputError1">${examController.examErr}</label>
					</fieldset>
					<fieldset class="form-group">
						<label for="inputData">Data Esame: </label>
						<h:inputText value="#{examController.visitDate}"
							styleClass="form-control" required="true"
							requiredMessage="Data obbligatoria" id="inputData">
							<f:convertDateTime pattern="dd-MM-yyyy" />
						</h:inputText>
						<h:message for="dataDiPrenotazione" />
					</fieldset>
					<fieldset class="form-group">
						<label for="idmedic">Medico: </label>
						<h:selectOneMenu value="#{examController.idmedic}">
							<c:forEach var="medic" items="#{medicController.medics}">
								<f:selectItem itemValue="#{medic.id}"
									itemLabel="#{medic.name} #{medic.surname}" />
							</c:forEach>
						</h:selectOneMenu>
						<br />
					</fieldset>
					<fieldset class="form-group">
						<label for="idtypology">Tipologia: </label>
						<h:selectOneMenu value="#{examController.idtypology}">
							<c:forEach var="examTypology"
								items="#{examTypologyController.examTypologies}">
								<f:selectItem itemValue="#{examTypology.id}"
									itemLabel="#{examTypology.name}" />
							</c:forEach>
						</h:selectOneMenu>
						<br />
					</fieldset>
					<fieldset class="form-group">
						<label for="idpatient">Paziente: </label>
						<h:selectOneMenu value="#{examController.idpatient}">
							<c:forEach var="patient" items="#{patientController.patients}">
								<f:selectItem itemValue="#{patient.id}"
									itemLabel="#{patient.name} #{patient.surname}" />
							</c:forEach>
						</h:selectOneMenu>
						<br />
					</fieldset>
					<fieldset class="form-group">
						<label for="inputDescription">Descrizione: </label>
						<h:inputText id="inputDescription"
							value="#{examController.description}" styleClass="form-control"
							required="true" requiredMessage="Descrizione obbligatoria" />
						<h:message for="inputDescription" />
						<br />
					</fieldset>

					<fieldset class="form-group">
						<label for="inputPrice">Prezzo: </label>
						<h:inputText id="inputPrice" value="#{examController.price}"
							styleClass="form-control" required="true"
							requiredMessage="Prezzo obbligatorio" />
						<h:message for="inputDescription" />
						<br />
					</fieldset>
					<div>
						<h:commandButton value="Invia"
							action="#{examController.createExam}" />
					</div>
					<br>
					<div>
						<a href='<c:url value="./admin.jsp" />'>Torna indietro</a> <br>
					</div>

				</h:form>
			</f:view>
		</div>
	</div>
</body>
</html>
