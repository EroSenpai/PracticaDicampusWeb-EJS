<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar profesores</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Buscar profesores</h2><br><br>
	<form action="./buscar-profesores.jsp" method="post">
		Introduce nombre y apellidos o DNI: <br><input type="text" name="busqueda" size="25"><br><br> 
		<input type="submit" name="boton" value="Buscar">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Profesor" scope="session"></jsp:useBean>

	Nombre y apellidos:
	<jsp:getProperty name="bean" property="nombre"></jsp:getProperty>
	<jsp:getProperty name="bean" property="apellidos"></jsp:getProperty><br><br> 	
	Número de DNI:
	<jsp:getProperty name="bean" property="dni"></jsp:getProperty><br><br> 
	Dirección:
	<jsp:getProperty name="bean" property="direccion"></jsp:getProperty><br><br> 
	Email:
	<jsp:getProperty name="bean" property="email"></jsp:getProperty><br><br> 
	Teléfono:
	<jsp:getProperty name="bean" property="telefono"></jsp:getProperty><br><br>
	Asignaturas impartidas:
	<!-- Falta ver cómo hacemos esto -->
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>