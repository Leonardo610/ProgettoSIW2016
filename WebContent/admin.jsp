<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
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
					<li class="active"><a href="./index.jsp" data-toggle="tab">Home</a></li>
					<li><a href="./chiSiamo.jsp">Chi siamo</a></li>
					<li><a href="./tipologieEsami.jsp">Esami</a></li>
					<li><a href="./admin.jsp">Area Utenti</a></li>
					<li><a href="./info.jsp" data-toggle="tab">Info</a></li>
					<li><a href="./contatti.jsp" data-toggle="tab">Contatti</a></li>
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

		<f:view>
			<div align="center">
				<h1>Benvenuto ${administratorController.administrator.name}!</h1>
				<h2>Sei loggato come Amministratore:</h2>
				<h4>Azioni possibili</h4>
			</div>
			<hr
				style="width: 30%; color: black; height: 1px; background-color: black;" />
			<div align="center">
				<h3>
					<a href="newTipologiaEsame.jsp">Inserisci Tipologia Esame</a>
				</h3>
			</div>
			<hr
				style="width: 30%; color: black; height: 1px; background-color: black;" />
			<div align="center">
				<h3>
					<a href="newPaziente.jsp">Inserisci nuovo Paziente</a>
				</h3>
			</div>
			<hr
				style="width: 30%; color: black; height: 1px; background-color: black;" />
			<div align="center">
				<h3>
					<a href="newPrenotazioneEsame.jsp">Prenota nuovo Esame</a>
				</h3>
			</div>
			<hr
				style="width: 30%; color: black; height: 1px; background-color: black;" />
			<div align="center">
				<h3>
					<a href="newMedico.jsp">Inserisci nuovo Medico</a>
				</h3>
			</div>
			<hr
				style="width: 30%; color: black; height: 1px; background-color: black;" />
			<div align="center">
				<h3>
					<a href="medici.jsp">Controlla Esami di un Medico</a>
				</h3>
			</div>
			<hr
				style="width: 30%; color: black; height: 1px; background-color: black;" />
			<div align="center">
				<h3>
					<a href="elencoPazienti.jsp">Inserisci risultati Esame</a>
				</h3>
			</div>
			<hr
				style="width: 30%; color: black; height: 1px; background-color: black;" />
			<br>
		</f:view>
	</div>

	<!-- SCRIPT -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="//code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>