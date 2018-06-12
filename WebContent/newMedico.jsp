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
					<li><a href="./info.html" data-toggle="tab">Info</a></li>
					<li><a href="./contatti.html" data-toggle="tab">Contatti</a></li>
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
		<div class="container">
			<h1>Inserimento nuovo Medico</h1>
			<br>
			<hr>
			<br>


			<!--  Inizio campi per la tipologia -->
			<f:view>
				<h:form>
					<fieldset class="form-group">
						<label for="code">Codice: </label>
						<h:inputText value="#{medicController.code}"
							styleClass="form-control" required="true"
							requiredMessage="Il nome e' obbligatorio!" id="code" />
						<h:message for="code" />
					</fieldset>
					<fieldset class="form-group">
						<label for="name">Nome: </label>
						<h:inputText value="#{medicController.name}"
							styleClass="form-control" required="true"
							requiredMessage="Il nome e' obbligatorio!" id="name" />
						<h:message for="name" />
					</fieldset>
					<fieldset class="form-group">
						<label for="surname">Cognome: </label>
						<h:inputText value="#{medicController.surname}"
							styleClass="form-control" required="true"
							requiredMessage="Il cognome e' obbligatorio!" id="surname" />
						<h:message for="surname" />
					</fieldset>
					<fieldset class="form-group">
						<label for="idmedic">Medico: </label>
						<h:selectOneMenu value="#{medicController.idspecialization}">
							<c:forEach var="examTypology"
								items="#{examTypologyController.examTypologies}">
								<f:selectItem itemValue="#{examTypology.id}"
									itemLabel="#{examTypology.name}" />
							</c:forEach>
						</h:selectOneMenu>
						<br />
					</fieldset>

					<fieldset class="form-group">
						<label for="pwd">Password: </label>
						<h:inputSecret value="#{medicController.pwd}"
							styleClass="form-control" required="true"
							requiredMessage="La password e' obbligatoria!" id="pwd" />
						<h:message for="pwd" />
					</fieldset>

					<div>
						<h:commandButton value="Inserisci"
							action="#{medicController.createMedico}" />
					</div>
					<br>
					<div>
						Non vuoi inserire un nuovo <i>Medico</i>? <a
							href='<c:url value="/faces/admin.jsp" />'>Torna indietro</a>!
					</div>

				</h:form>
			</f:view>


			<hr>

		</div>
	</div>
</body>
</html>