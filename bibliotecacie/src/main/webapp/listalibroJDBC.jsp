<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="es.cie.negocio.Libro"%>
<%@ page import="es.cie.repositories.LibroRepository"%>
<%@ page import="es.cie.repositories.jdbc.LibroRepositoryJDBC"%>
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
		LibroRepository repo = new LibroRepositoryJDBC();
		List<Libro> lista = null;

		if (request.getParameter("orden") != null) {
			out.println("Ordenado por " + request.getParameter("orden"));
			lista = repo.buscarTodosOrdenados(request.getParameter("orden"));
		} else {

			out.println("Lista sin ordenar");
			lista = repo.buscarTodos();
		}
		%>

		<h1>Listado de Libro</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th><a href="?orden=isbn"> ISBN </a></th>
					<th><a href="?orden=titulo"> Titulo </a></th>
					<th><a href="?orden=autor"> Autor </a></th>
					<th><a href="?orden=paginas"> Paginas </a></th>
					<th>Borrar</th>
				</tr>
			</thead>


			<%
			for (Libro l : lista) {
			%>

			<tr>
				<td><%=l.getIsbn()%></td>
				<td><%=l.getTitulo()%></td>
				<td><%=l.getAutor()%></td>
				<td><%=l.getPaginas()%></td>
				<td><a class="btn btn-secondary"
					href="?comando=borrarlibro&isbn=<%=l.getIsbn()%>"> Borrar</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<a href="?comando=formulariolibro"> Insertar Libro</a>
</body>
</html>