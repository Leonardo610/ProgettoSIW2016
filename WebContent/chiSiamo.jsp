<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">


<title>Chi siamo</title>
<link rel="shortcut icon"
	href="./lib/resources/bastone_asclepio_ico.ico" />
<!-- Bootstrap core CSS -->
<link href="./lib/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="./lib/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./lib/css/signin.css" rel="stylesheet">

<!-- Css for the template of navigation bar -->
<link href="./lib/css/index.css" rel="stylesheet">

<!-- CSS specifici per chiSiamo.html -->
<link href="./lib/css/chiSiamo.css">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
					<li class="active"><a href="./index.jsp" data-toggle="tab">Home</a></li>
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
		<div class="container">
		
		                 	<!-- NAVBAR END-->


			<img src="./lib/resources/bastone_asclepio.jpg" margin-left="50px"
				class="img_asclepio" />
			<div class="text_chiSiamo">
				Chi siamo La ClinicaAcme è una struttura
				clinica-scientifica-universitaria di rilievo internazionale e di
				alta specializzazione per diverse importanti patologie, inaugurata
				nel 1975 e riconosciuta nel 1976 "Istituto di Ricovero e Cura a
				Carattere Scientifico" . Nel 2016 sono stati effettuati
				complessivamente circa 3.211 interventi chirurgici, 44.233 ricoveri,
				950.431 prestazioni ambulatoriali e oltre 66.356 accessi al Pronto
				Soccorso. La ClinicaAcme è un Centro di Emergenza ad Alta Specialità
				(EAS). Nell'ambito della Ricerca, dal 2006 la ClinicaAcme è stata
				riconosciuta dal Ministero della Salute come Istituto di Ricovero e
				Cura a Carattere Scientifico per la specialità di Medicina
				Molecolare. Nel 2014 sono stati pubblicati 1163 articoli sulle più
				importanti riviste scientifiche internazionali. <br> <br>
				L'attuale struttura organizzativa è: <br> <br> Presidente
				Prof. Riccardo Benzoni <br> Vice Presidente Dott. Paola Rossi <br>
				Amministratore Delegato Dott. Nicola Verdi <br> Direttore
				Sanitario Dott. Roberts Emanuel <br>
			</div>
			<br> <br>
		</div>
	</div>
</body>
</html>