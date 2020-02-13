<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/">Home</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Client/All">Client</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Plat/All">Plat</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Menu/All">Menu</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Reservation/All">Réservations</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/User/All">User</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Role/All">Role</a></li>
	</ul>

	<h3>Page User</h3>
<br>
	<form:form action="Ajout" method="post">
		<table>
			<tr>
				<td>Introduire l'id de l'utilisateur<input type="text"
					name="iduser"></td>
				<td>Introduire le nom de l'utilisateur<input type="text"
					name="username"></td>
				<td>Introduire le password de l'utilisateur<input type="text"
					name="password"></td>
				<td>Introduire l'état<input type="text" name="activated"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter un utilisateur" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>

	<form:form action="MAJ" method="post">
		<table>
			<tr>
				<td>Introduire l'id de l'utilisateur<input type="text"
					name="iduser"></td>
				<td>Introduire le nom de l'utilisateur<input type="text"
					name="username"></td>
				<td>Introduire le password de l'utilisateur<input type="text"
					name="password"></td>
				<td>Introduire l'état<input type="text" name="activated"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Mettre à jour un utilisateur" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>

	<form:form action="Supprimer" method="post">
		<table>
			<tr>
				<td>Introduire l'id de l'utilisateur<input type="text"
					name="iduser"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Supprimer un utilisateur" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>


	<form:form action="All" method="get">
		<input class="btn btn-primary" type="submit"
			value="Afficher tous les utilisateurs" name="action">
		<br>
		<br>
		<p>
			<b> Liste des utilisateurs </b>
		</p>
		<table class="table table-striped">
			<tr>
				<th>Id User</th>
				<th>Username</th>
				<th>Password</th>
				<th>Etat</th>
			</tr>
			<c:forEach items="${listeDesUsers}" var="user">
				<tr>
					<td>${user.iduser }</td>
					<td>${user.username }</td>
					<td>${user.password }</td>
					<td>${user.activated }</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>