<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar alumnos</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Eliminar alumnos</h2><br><br>
	<form action="./borrar-alumnos.jsp" method="post">
		Introduce nombre y apellidos o n�mero de matr�cula: <br><input type="text" name="busqueda" size="25"><br><br> 
		<input type="submit" name="boton" value="Eliminar">
	</form></div>


	<div><jsp:include page="./footer.html" /></div>
</body>
</html>