<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>A�adir profesores</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>A�adir profesores</h2><br><br>
	<form action="./agrgar-profesores.jsp" method="post">
		Nombre y apellidos: <br><input type="text" name="nombreApellidos" size="25"><br><br> 
		Direcci�n: <br><input type="text" name="direcci�n" size="25"><br><br> 
		Email: <br><input type="text" name="email" size="25"><br><br>
		Tel�fono: <br><input type="text" name="telefono" size="25"><br><br>
		DNI: <br><input type="text" name="dni" size="25"><br><br>
		Asignaturas impartidas (por identificador, separadas por comas): <br><input type="text" name="impartidas" size="25"><br><br>
		<input type="submit" name="boton" value="A�adir">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Profesor" scope="session"></jsp:useBean>

	<jsp:getProperty name="bean" property="mensaje"></jsp:getProperty>
	
	<!-- A�adir un m�todo que devuelva un string con mensaje de correcto o incorrecto seg�n proceda -->
	
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>