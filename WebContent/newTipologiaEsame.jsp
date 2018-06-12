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
					<li class="active"><a href="./index.jsp">Home</a></li>
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


		<!-- NAVBAR  END-->

		<div class="container">
			<h1>Inserimento nuova Tipologia Esame</h1>
			<br>
			<hr>
			<br>



			<f:view>
				<h:form>
					<fieldset class="form-group">
						<label for="nome">Nome: </label>
						<h:inputText value="#{examTypologyController.name}"
							styleClass="form-control" required="true"
							requiredMessage="Il nome e' obbligatorio!" id="nome" />
						<h:message for="nome" />
					</fieldset>

					<label for="descrizione">Descrizione: </label>
					<h:inputTextarea value="#{examTypologyController.detail}"
						styleClass="form-control" required="false" cols="20" rows="5"
						id="descrizione">
						<f:validateLength maximum="2000" />
					</h:inputTextarea>
					<h:message for="descrizione" />

					<label for="idindicator">Indicatore: </label>
					<h:selectOneMenu value="#{indicatorController.id}">
						<c:forEach var="indicator"
							items="#{indicatorController.indicators}">
							<f:selectItem itemValue="#{indicator.id}"
								itemLabel="#{indicator.name}" />
						</c:forEach>
					</h:selectOneMenu>

					<h:commandLink action="#{examTypologyController.addIndicator}"
						value="inserisci indicatore">
						<f:param name="idindicator" value="#{indicatorController.id}" />
					</h:commandLink>
					









					<div>
						<h:commandButton value="Inserisci"
							action="#{examTypologyController.createExamTypology}" />
					</div>
					<br>
					<div>
						<a href='<c:url value="./faces/admin.jsp" />'>Torna alla home</a>
					</div>

				</h:form>
			</f:view>
			<hr>

		</div>
	</div>
</body>
</html>