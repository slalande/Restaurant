<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
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
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

<a href="<c:url value="/j_spring_security_logout"/>" > Logout</a>

	<table>
		<tr>
			<td><a class="nav-link" href="/myapp/Matiere/All"
				style="color: black"><button type="button" class="btn btn-link">Matiere</button></a></td>
			<td><a class="nav-link" href="/myapp/Etudiant/All"
				style="color: black"><button type="button" class="btn btn-link">Etudiant</button></a></td>
			<td><a class="nav-link" href="/myapp/User/All"
				style="color: black"><button type="button" class="btn btn-link">Utilisateur</button></a></td>
			<td><a class="nav-link" href="/myapp/Role/All"
				style="color: black"><button type="button" class="btn btn-link">Role</button></a></td>

		</tr>
	</table>

</body>
</html>
