<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar cursos</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Eliminar cursos</h2><br><br>
	<form action="./borrar-cursos.jsp" method="post">
		Introduce nombre o identificador: <br><input type="text" name="busqueda" size="25"><br><br> 
		<input type="submit" name="boton" value="Eliminar">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Curso" scope="session"></jsp:useBean>

	<jsp:getProperty name="bean" property="mensaje"></jsp:getProperty>
	
	<!-- Añadir un método que devuelva un string con mensaje de correcto o incorrecto según proceda -->
	
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>