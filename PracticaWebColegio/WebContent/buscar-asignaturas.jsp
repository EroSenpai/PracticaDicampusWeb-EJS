<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar asignaturas</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Buscar asignaturas</h2><br><br>
	<form action="./buscar-asignaturas.jsp" method="post">
		Introduce nombre o identificador: <br><input type="text" name="busqueda" size="25"><br><br> 
		<input type="submit" name="boton" value="Buscar">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Asignatura" scope="session"></jsp:useBean>

	Nombre:
	<jsp:getProperty name="bean" property="nombre"></jsp:getProperty><br><br> 	
	N�mero identificador:
	<jsp:getProperty name="bean" property="id"></jsp:getProperty><br><br> 
	Cr�ditos:
	<jsp:getProperty name="bean" property="numCreditos"></jsp:getProperty><br><br> 
	Plazas:
	<jsp:getProperty name="bean" property="maxAlumnos"></jsp:getProperty><br><br> 
	
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>