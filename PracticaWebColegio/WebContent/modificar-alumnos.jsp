<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar alumnos</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Modificar datos de alumno</h2><br><br>
	<form action="./modificar-alumnos.jsp" method="post">
		
		N�mero de matr�cula del alumno: <br><input type="text" name="matricula" size="25"><br><br><br>
		
		<h3>Nuevos datos</h3><br> 
		
		Nombre y apellidos: <br><input type="text" name="nombreApellidos" size="25"><br><br> 
		Direcci�n: <br><input type="text" name="direcci�n" size="25"><br><br> 
		Email: <br><input type="text" name="email" size="25"><br><br>
		Tel�fono: <br><input type="text" name="telefono" size="25"><br><br>
		<input type="submit" name="boton" value="Modificar">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Alumno" scope="session"></jsp:useBean>

	<jsp:getProperty name="bean" property="mensaje"></jsp:getProperty>
	
	<!-- A�adir un m�todo que devuelva un string con mensaje de correcto o incorrecto seg�n proceda -->
	
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>