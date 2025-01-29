<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="es.cie.negocio.Ejemplar"%>
<%@ page import="es.cie.repositories.EjemplarRepository"%>
<%@ page import="es.cie.repositories.jdbc.EjemplarRepositoryJDBC"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EJEMPLARES LIBRO</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<h1>Biblioteca CIE</h1>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="container">


		<%
		EjemplarRepository repo = new EjemplarRepositoryJDBC();
	
		List<Ejemplar> lista = null;

	

		if (request.getParameter("orden") != null) {
			out.println("Ordenado por " + request.getParameter("orden"));
			lista = repo.buscarTodosOrdenados(request.getParameter("orden"));
		} else {

			out.println("Lista sin ordenar");
			lista = repo.buscarTodos();
		}
		%>

		<h1>Listado de Ejemplares</h1>



		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th><a href="?orden=id"> ID</a></th>
					<th><a href="?orden=isbn">ISBN</a></th>
					<th><a href="?orden=titulo">Titulo</a></th>
					<th><a href="?orden=autor">Autor</a></th>
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
				<td><a class="btn btn-secondary"
					href="?comando=borrarejemplar&id=<%=e.getId()%>"> Borrar</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<button type="button" class="btn btn-warning">
			<a href="?comando=formularioejemplar"> Insertar ejemplar </a>
		</button>
</body>
</html>