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

	<table>
		<tr>
			<td><a class="nav-link" href="/myapp" style="color: black"><button
						type="button" class="btn btn-link">Home</button></a></td>
			<td><a class="nav-link" href="/myapp/Matiere/All"
				style="color: black"><button type="button" class="btn btn-link">Matiere</button></a></td>
			<td><a class="nav-link" href="/myapp/User/All"
				style="color: black"><button type="button" class="btn btn-link">User</button></a></td>
			<td><a class="nav-link" href="/myapp/Role/All"
				style="color: black"><button type="button" class="btn btn-link">Role</button></a></td>
		</tr>
	</table>

	<form:form action="Ajout" method="post">
		<table>
			<tr>

				<td>Introduire l'id de l'etudiant<input type="text"
					name="idEtudiant"></td>
				<td>Introduire le nom de l'etudiant<input type="text"
					name="nomEtudiant"></td>
				<td>Introduire le prénom de l'etudiant<input type="text"
					name="prenomEtudiant"></td>
				<td><input class="btn btn-primary" type="submit"
					value="AjoutEtudiant" name="action"></td>

			</tr>

		</table>
	</form:form>
	<br></br>

	<form:form action="Supprimer" method="get">
		<table>
			<tr>

				<td>Introduire l'id de l'etudiant<input type="text"
					name="idEtudiant"></td>
				<!-- 				<td>Introduire le nom de l'etudiant<input type="text" -->
				<!-- 					name="nomEtudiant"></td> -->
				<!-- 					<td>Introduire le prénom de l'etudiant<input type="text" -->
				<!-- 					name="prenomEtudiant"></td> -->
				<td><input class="btn btn-primary" type="submit"
					value="Supprimer un Etudiant" name="action"></td>

			</tr>

		</table>
	</form:form>
	<br>
	<form:form action="All" method="get">
		<input class="btn btn-primary" type="submit"
			value="afficher tous les étudiants" name="action">
		<br>
		<br>
		<p>
			<b>Liste des etudiants </b>
		</p>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Id Etudiant</th>
				<th>Nom etudiant</th>
				<th>Prenom etudiant</th>

			</tr>
			<c:forEach items="${listeDesEtudiants}" var="mat">
				<tr>
					<td>${mat.idEtudiant }</td>
					<td>${mat.nomEtudiant }</td>
					<td>${mat.prenomEtudiant }</td>

				</tr>
			</c:forEach>


		</table>

	</form:form>



</body>
</html>