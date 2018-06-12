<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">


<title>Info</title>
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
					<li><a href="info.jsp">Info</a></li>
					<li><a href="contatti.jsp">Contatti</a></li>
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

		                             <!-- NAVBAR END  -->
		                             
		                             
		
		<div class="container">
			<img src="./lib/resources/bastone_asclepio.jpg" margin-left="50px"
				class="img_asclepio" />
			<div class="text_info">
				<h2>Che cosa portare in ospedale in caso di ricovero</h2>
				<br> <br> occorre portare con sé: <br> tessera
				sanitaria comprensiva di codice fiscale<br> documento di
				identità (carta d’identità, patente)<br> tutta la
				documentazione sanitaria (esami, radiografie, ecc.) eventualmente in
				possesso, che sarà restituita al termine del ricovero. <br>Durante
				la degenza, saranno a Sua disposizione un armadietto e un comodino.
				Porti con sé solo gli effetti personali di stretta necessità e gli
				oggetti da toeletta:<br> <br> pigiami e biancheria
				personale<br> vestaglia o giacca da camera e pantofole<br>
				spazzolino da denti, dentifricio, sapone, pettine, rasoio<br>
				asciugamani e tovaglioli<br> <br> La preghiamo di tenere
				sul comodino solo gli oggetti indispensabili, per facilitare la
				pulizia. <br> <br> Che cosa non portare in ospedale:<br>
				<br> Farmaci personali (se non direttamente autorizzati dal
				medico di reparto) alimenti o bevande di qualsiasi genere, inoltre
				si sconsiglia di portare denaro in quantità elevata, gioielli o
				altri oggetti di valore per i quali l’azienda non risponde di
				eventuali furti o smarrimenti.

			</div>
		</div>
	</div>

</body>
</html>