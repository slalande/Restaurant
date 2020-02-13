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
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form:form action="initlogin" method="get">

<input class="btn btn-primary" type="submit" value="Login" name="action">
	
</form:form>
<!-- <br> -->
<%-- <form:form action="initEtudiant" method="get"> --%>

<!-- <input class="btn btn-primary" type="submit" value="Etudiants" name="action"> -->
	
<%-- </form:form> --%>

</body>
</html>
