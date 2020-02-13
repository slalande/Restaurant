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
			href="http://localhost:2000/Reservation/All">R�servations</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/User/All">User</a></li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:2000/Role/All">Role</a></li>
	</ul>

	<h3>Page Role</h3>
<br>
	<form:form action="Ajout" method="post">
		<table>
			<tr>
				<td>Introduire l'id du role<input type="text" name="idrole"></td>
				<td>Introduire le nom du role<input type="text" name="rolename"></td>
				<td>Introduire l'utilisateur<input type="text"
					name="user.iduser"></td>
				<!-- 				<td>Utilisateur<select name="test" multiple="multiple"> -->
				<%-- 						<c:forEach items="${listeDesUsers}" var="id"> --%>
				<%-- 							<option value="${user.iduser}">${user.username}</option> --%>
				<%-- 						</c:forEach> --%>
				<!-- 				</select></td> -->
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter un role" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>

	<form:form action="MAJ" method="post">
		<table>
			<tr>
				<td>Introduire l'id du role<input type="text" name="idrole"></td>
				<td>Introduire le nom du role<input type="text" name="rolename"></td>
				<td>Introduire l'utilisateur<input type="text"
					name="user.iduser"></td>
				<!-- 				<td>Utilisateur<select name="test" multiple="multiple"> -->
				<%-- 						<c:forEach items="${listeDesUsers}" var="id"> --%>
				<%-- 							<option value="${user.iduser}">${user.username}</option> --%>
				<%-- 						</c:forEach> --%>
				<!-- 				</select></td> -->
				<td><input class="btn btn-primary" type="submit"
					value="Mettre � jour un role" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<form:form action="Supprimer" method="post">
		<table>
			<tr>
				<td>Introduire l'id du role<input type="text" name="idrole"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Supprimer un role" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<form:form action="ByID" method="get">
		<table>
			<tr>
				<td>Introduire l'id du role<input type="text" name="idrole"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Rechercher un role par ID" name="action"></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<form:form action="All" method="get">
		<input class="btn btn-primary" type="submit"
			value="Afficher tous les roles" name="action">
		<br>
		<br>
		<p>
			<b> Liste des roles </b>
		</p>
		<table class="table table-striped">
			<tr>
				<th>Id Role</th>
				<th>Rolename</th>
				<th>Utilisateur</th>
			</tr>
			<c:forEach items="${listeDesRoles}" var="role">
				<tr>
					<td>${role.idrole }</td>
					<td>${role.rolename }</td>
					<td>${role.user.iduser }</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>