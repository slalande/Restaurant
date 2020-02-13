<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<li class="nav-item"><a class="nav-link" href="http://localhost:2000/">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="http://localhost:2000/Client/All">Client</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="http://localhost:2000/Plat/All">Plat</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="http://localhost:2000/Menu/All">Menu</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="http://localhost:2000/Reservation/All">Réservations</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="http://localhost:2000/User/All">User</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="http://localhost:2000/Role/All">Role</a>
		</li>
	</ul>
	
	<h3>Page Client</h3>
<br>	
	<form:form action="Ajout" method="post">
		<table>
			<tr>
				<td>Introduire l'id du client<input type="text"
					name="idClient"></td>
				<td>Introduire le nom<input type="text"
					name="nom"></td>
				<td>Introduire le téléphone<input type="text"
					name="tel"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter un client" name="actionClient"></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<form:form action="MAJ" method="post">
		<table>
			<tr>
				<td>Introduire l'id du client<input type="text"
					name="idClient"></td>
				<td>Introduire le nom<input type="text"
					name="nom"></td>
				<td>Introduire le téléphone<input type="text"
					name="tel"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Mettre à jour un client" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>

	<form:form action="Supprimer" method="post">
		<table>
			<tr>
				<td>Introduire l'id du client<input type="text"
					name="idClient"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Supprimer un client" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<form:form action="ByID" method="get">
		<table>
			<tr>
				<td>Introduire l'id du client<input type="text"
					name="idClient"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Rechercher un client par ID" name="action"></td>
			</tr>
		</table>		
	</form:form>
	
	<br>
	<form:form action="All" method="get">
		<input class="btn btn-primary" type="submit"
			value="afficher tous les clients" name="action">
		<br>
		<br>
		<p>
			<b>Liste des clients </b>
		</p>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Id Client</th>
				<th>Nom</th>
				<th>Téléphone</th>
			</tr>
			<c:forEach items="${listeDesClients}" var="cl">
				<tr>
					<td>${cl.idClient}</td>
					<td>${cl.nom}</td>
					<td>${cl.tel}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>


</body>
</html>