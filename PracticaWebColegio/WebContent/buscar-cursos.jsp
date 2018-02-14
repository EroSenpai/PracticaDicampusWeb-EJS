<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar cursos</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Buscar cursos</h2><br><br>
	<form action="./buscar-cursos.jsp" method="post">
		Introduce nombre o identificador: <br><input type="text" name="busqueda" size="25"><br><br> 
		<input type="submit" name="boton" value="Buscar">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Curso" scope="session"></jsp:useBean>

	Nombre:
	<jsp:getProperty name="bean" property="nombre"></jsp:getProperty><br><br> 	
	Número identificador:
	<jsp:getProperty name="bean" property="id"></jsp:getProperty><br><br> 
	Profesor:
	<jsp:getProperty name="bean" property="profesor"></jsp:getProperty><br><br> 
	Aula:
	<jsp:getProperty name="bean" property="aula"></jsp:getProperty><br><br> 
	Fecha de inicio:
	<jsp:getProperty name="bean" property="fechaInicio"></jsp:getProperty><br><br>
	Fecha de finalización:
	<jsp:getProperty name="bean" property="fechaFinal"></jsp:getProperty><br><br>
	Alumnos inscritos:
	<!-- Falta ver cómo hacemos esto -->
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>