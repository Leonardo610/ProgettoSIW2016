<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="lib/css/index.css" rel="stylesheet">
<link href="lib/css/bootstrap.min.css" rel="stylesheet">
<link rel="shortcut icon"
	href="./lib/resources/bastone_asclepio_ico.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: 0 auto;
}
</style>


<title>ClinicaAcme</title>
</head>
                    

<body>
                                  <!-- NAVBAR -->
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
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">ClinicaAcme</h3>
			<span class="pull-right">

				<ul class="nav panel-tabs">
					<li class="active"><a href="./index.jsp" data-toggle="tab">Home</a></li>
					<li><a href="./chiSiamo.jsp">Chi siamo</a></li>
					<li><a href="./tipologieEsami.jsp">Esami</a></li>
					<li><a href="./login.jsp">Area Utenti</a></li>
					<li><a href="./info.jsp" >Info</a></li>
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

                             <!-- NAVBAR END -->
                             

			<!-- CAROUSEL -->
			<section class="section-white">
				<div class="container">

					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li class="item1 active"></li>
							<li class="item2"></li>
							<li class="item3"></li>
							<li class="item4"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="lib/resources/clinica.jpg" alt="...">
								<div class="carousel-caption">
									<h3>Clinica Medica Acme</h3>
									<p>Tecnologie avanzate</p>
								</div>
							</div>
							<div class="item">
								<img src="lib/resources/clinica2.jpg" alt="...">
								<div class="carousel-caption">
									<h3>Clinica Medica Acme</h3>
									<p>Ambiente confortevole</p>
								</div>

							</div>
							<div class="item">
								<img src="lib/resources/clinica3.jpg" alt="...">
								<div class="carousel-caption">
									<h3>Clinica Medica Acme</h3>
									<p>Professionalità</p>
								</div>

							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> </a> <span
							class="glyphicons glyphicons-chevron-left"></span><a
							class="right carousel-control" href="#carousel-example-generic"
							data-slide="next"> </a> <span
							class="glyphicons glyphicons-chevron-right"></span>

					</div>

				</div>
			</section>
			<!-- /.carousel -->
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<script>
		$(document).ready(function() {
			// Activate Carousel
			$("#myCarousel").carousel();

			// Enable Carousel Indicators
			$(".item1").click(function() {
				$("#myCarousel").carousel(0);
			});
			$(".item2").click(function() {
				$("#myCarousel").carousel(1);
			});
			$(".item3").click(function() {
				$("#myCarousel").carousel(2);
			});
			$(".item4").click(function() {
				$("#myCarousel").carousel(3);
			});

			// Enable Carousel Controls
			$(".left").click(function() {
				$("#myCarousel").carousel("prev");
			});
			$(".right").click(function() {
				$("#myCarousel").carousel("next");
			});
		});
	</script>
</body>
</html>