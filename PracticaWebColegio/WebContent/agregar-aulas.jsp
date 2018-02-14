<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir aulas</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Añadir asignaturas</h2><br><br>
	<form action="./agregar-aulas.jsp" method="post">
		Nombre: <br><input type="text" name="nombre" size="25"><br><br> 
		Capacidad: <br><input type="text" name="capacidad" size="25"><br><br> 
		<input type="submit" name="boton" value="Añadir">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Aula" scope="session"></jsp:useBean>

	<jsp:getProperty name="bean" property="mensaje"></jsp:getProperty>
	
	<!-- Añadir un método que devuelva un string con mensaje de correcto o incorrecto según proceda -->
	
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>