<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar cursos</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<div><jsp:include page="./header.html" /></div>

	<div style="padding:80px"><br><br><h2>Modificar datos de curso</h2><br><br>
	<form action="./modificar-cursos.jsp" method="post">
		
		Identificador del curso: <br><input type="text" name="id" size="25"><br><br><br>
		
		<h3>Nuevos datos</h3><br> 
		
		Nombre: <br><input type="text" name="nombre" size="25"><br><br> 
		Profesor (número de DNI): <br><input type="text" name="profesor" size="25"><br><br> 
		Aula: <br><input type="text" name="aula" size="25"><br><br>
		Fecha de inicio: <br><input type="text" name="empieza" size="25"><br><br>
		Fecha de finalización: <br><input type="text" name="acaba" size="25"><br><br>
		Alumnos inscritos (número de matricula, separados por comas): <br><input type="text" name="inscritos" size="25"><br><br>
		<input type="submit" name="boton" value="Modificar">
	</form></div>

	<%if (request.getParameter("boton") != null) {%>

	<jsp:useBean id="bean" class="beans.Curso" scope="session"></jsp:useBean>

	<jsp:getProperty name="bean" property="mensaje"></jsp:getProperty>
	
	<!-- Añadir un método que devuelva un string con mensaje de correcto o incorrecto según proceda -->
	
	<%}%>

	<div><jsp:include page="./footer.html" /></div>
</body>
</html>