<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar alumnos</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Buscar alumnos</h2><br><br>
	<form action="./" method="post">
		Introduce nombre y apellidos o n�mero de matr�cula: <br><input type="text" name="busqueda" size="25"><br><br> 
		<input type="submit" name="boton" value="Buscar">
	</form></div>

	<%if (request.getParameter("boton") != null) {%> 
	
	<jsp:useBean id="alumno" class="beans.Alumno" scope="session"></jsp:useBean>

	Nombre y apellidos: <jsp:getProperty name="alumno" property="nombre"></jsp:getProperty> <jsp:getProperty name="alumno" property="apellido"></jsp:getProperty><br>
	N�mero de matr�cula: <jsp:getProperty name="alumno" property="numMatricula"></jsp:getProperty><br>
	Direcci�n: <jsp:getProperty name="alumno" property="direccion"></jsp:getProperty><br>
	Email: <jsp:getProperty name="alumno" property="email"></jsp:getProperty><br>
	Tel�fono: <jsp:getProperty name="alumno" property="telefono"></jsp:getProperty><br>

	<%} %>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>