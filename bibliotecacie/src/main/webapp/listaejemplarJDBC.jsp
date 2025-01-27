<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="es.cie.negocio.Ejemplar"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<h1>Datos</h1>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="container">


	<%
	List<Ejemplar> lista=(List<Ejemplar>) request.getAttribute("lista");
	%>
	<h1>Listado de Ejemplares</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th> ID</th>
				<th> ISBN</th>
				<th> Titulo</th>
				<th> Autor</th>
				<th>Borrar</th>
			</tr>
		</thead>
 

		<%
 		for (Ejemplar e : lista) {
 		%>
		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getIsbn()%></td>
			<td><%=e.getTitulo()%></td>
			<td><%=e.getAutor()%></td>
			<td><a class="btn btn-secondary" href="?comando=borrarsocio&dni=<%=e.getId()%>">
					Borrar</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="?comando=formularioejemplar"> Insertar ejemplar</a>


</body>
</html>