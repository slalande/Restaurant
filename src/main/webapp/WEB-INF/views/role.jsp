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
	<table>
		<tr>
			<td><a class="nav-link" href="/myapp" style="color: black"><button
						type="button" class="btn btn-link">Home</button></a></td>
			<td><a class="nav-link" href="/myapp/Etudiant/All"
				style="color: black"><button type="button" class="btn btn-link">Etudiant</button></a></td>
			<td><a class="nav-link" href="/myapp/Matiere/All"
				style="color: black"><button type="button" class="btn btn-link">Matière</button></a></td>
			<td><a class="nav-link" href="/myapp/User/All"
				style="color: black"><button type="button" class="btn btn-link">Rôle</button></a></td>

		</tr>
	</table>


	<form:form action="Ajout" method="post">
		<table>
			<tr>

				<td>Introduire l'id du role<input type="text"
					name="idrole"></td>
				<td>Introduire le nom du role<input type="text"
					name="rolename"></td>
				<td>Introduire l'id de l'utilisateur<input type="text"
					name="user.iduser"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter un role" name="action"></td>

			</tr>

		</table>
	</form:form>
	<br>
	<form:form action="Supprimer" method="post">
		<table>
			<tr>

				<td>Introduire l'id du role<input type="text"
					name="idrole"></td>
				<td><input class="btn btn-primary" type="submit"
					value="Supprimer un role" name="action"></td>

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
				<th>User</th>

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