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

	<div style="padding: 80px">
		<br> <br>
		<h2>Buscar alumnos</h2>
		<br> <br>
		<form action="./buscar-alumnos.jsp" method="post">
			Introduce nombre y apellidos o número de matrícula: <br> <input
				type="text" name="busqueda" size="25"><br> <br> <input
				type="submit" name="boton" value="Buscar">
		</form>
	</div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Alumno" scope="session"/>

	Nombre y apellidos:
	<jsp:getProperty name="bean" property="nombre"></jsp:getProperty>
	<jsp:getProperty name="bean" property="apellidos"></jsp:getProperty><br><br> 	
	Número de matrícula:
	<jsp:getProperty name="bean" property="numMatricula"></jsp:getProperty><br><br> 
	Dirección:
	<jsp:getProperty name="bean" property="direccion"></jsp:getProperty><br><br> 
	Email:
	<jsp:getProperty name="bean" property="email"></jsp:getProperty><br><br> 
	Teléfono:
	<jsp:getProperty name="bean" property="telefono"></jsp:getProperty><br><br>
	
	<%}%>
	
	<div><jsp:include page="./footer.html" /></div>
</body>
</html>