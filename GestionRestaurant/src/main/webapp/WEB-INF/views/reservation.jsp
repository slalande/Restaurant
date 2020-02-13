<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<title>Insert title here</title>
</head>
<body>
	<script src="jquery-3.4.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

			<a href="<c:url value="/logout"/>"> Logout</a>

	<ul class="nav">
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/">Home</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Client/All">Client</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Plat/All">Plat</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Menu/All">Menu</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Reservation/All">Réservations</a>
		</li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/User/All">User</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Role/All">Role</a></li>
	</ul>
	
	<h3>Page Réservation</h3>
<br>
	<form:form action="Ajout" method="post">
		<table>
			<tr>
				<td>id Réservation<input type="text" name="idReservation"></td>
				<td>Nombre de personnes<input type="text" name="nbPersonnes"></td>
				<td>Date<input type="text" id="datepicker" name="date"></td>
				<td>Client<input type="text" name="client.idClient"></td>
				<td>Menu<select name="test" multiple="multiple">
						<c:forEach items="${listeDesMenus}" var="id">
							<option value="${id.idMenu}">${id.nomMenu}</option>
						</c:forEach>
				</select></td>
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter une réservation" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br></br>
	
	<form:form action="MAJ" method="post">
		<table>
			<tr>
				<td>id Réservation<input type="text" name="idReservation"></td>
				<td>Nombre de personnes<input type="text" name="nbPersonnes"></td>
				<td>Date<input type="text" id="datepicker" name="date"></td>
				<td>Client<input type="text" name="client.idClient"></td>
				<td>Menu<select name="test" multiple="multiple">
						<c:forEach items="${listeDesMenus}" var="id">
							<option value="${id.idMenu}">${id.nomMenu}</option>
						</c:forEach>
				</select></td>
				<td><input class="btn btn-primary" type="submit"
					value="Mettre à jour une réservation" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br></br>

	<form:form action="Supprimer" method="post">
		<table>
			<tr>
				<td>Id réservation<input type="text" name="idReservation"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Supprimer une réservation" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<form:form action="ByID" method="get">
		<table>
			<tr>
				<td>Id réservation<input type="text" name="idReservation"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Rechercher une réservation par ID" name="action"></td>
			</tr>
		</table>
	</form:form>

	<br>
	<form:form action="All" method="get">
		<input class="btn btn-primary" type="submit"
			value="afficher toutes les réservations" name="action">
		<br>
		<br>
		<p>
			<b>Liste des réservations </b>
		</p>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Id Réservation</th>
				<th>Nombre de personnes</th>
				<th>Date</th>
				<th>Client</th>
				<th>Menus</th>
			</tr>
			<c:forEach items="${listeDesReservations}" var="res">
				<tr>
					<td>${res.idReservation}</td>
					<td>${res.nbPersonnes}</td>
					<td>${res.date}</td>
					<td>${res.client.idClient}</td>
					<td>${res.lstmenus}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>



</body>
</html>