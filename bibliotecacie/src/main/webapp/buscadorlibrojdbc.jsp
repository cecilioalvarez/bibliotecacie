<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

ç
<%@ page import="es.cie.negocio.Libro"%>
<%@ page import="java.util.List"%>

<% List<Libro>  lista= (List<Libro>)request.getAttribute("lista"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buscador</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="container">

	<form method="get">
		<select name="tipobusqueda">
			<option>titulo</option>
			<option>autor</option>
		</select> 
		<input type="hidden" name="comando" value="buscar"/>
		<input type="text" name="textobusqueda" /> <input type="submit" class="btn btn-warning" value="Buscar" />
	</form>


	<h1>Lista De Libros</h1>
	<table class="table table-striped table-hover">
		
		<tr>
			<th>isbn</th>
			<th>titulo</th>
			<th>autor</th>
			<th>paginas</th>
		</tr>

		<%
		//for each
		for (Libro libro : lista) {
		%>

		<!-- fila o row tr (table row) -->
		<tr>
			<td><%=libro.getIsbn()%></td>
			<td><%=libro.getTitulo()%></td>
			<td><%=libro.getAutor()%></td>
			<td><%=libro.getPaginas()%></td>



		</tr>

		<% } %>
	</table>
	<p>
	<a href="?comando=formulariolibro">insertar nuevo libro</a>
	</p>
	<p>
	<a href="http://localhost:8080/bibliotecacie/LibroServlet">ver listado completo</a>
	</p>
	</div>
</body>
</html>