<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="es.cie.repositories.LibroRepository"%>
<%@ page import="es.cie.repositories.jdbc.LibroRepositoryJDBC"%>
<%@ page import="es.cie.negocio.Libro"%>
<%@ page import="java.util.List"%>

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

	<% 
	LibroRepository repo= new LibroRepositoryJDBC();
	
	String tipobusqueda = request.getParameter("tipobusqueda");

	String textobusqueda = request.getParameter("textobusqueda");
	List<Libro> lista = null;
	
	if (tipobusqueda != null && textobusqueda != null) {
		if (tipobusqueda.equalsIgnoreCase("titulo")) {
			lista = repo.porTitulo(textobusqueda);
		} else if (tipobusqueda.equalsIgnoreCase("autor")) {
			lista = repo.porAutor(textobusqueda);

		} else if (tipobusqueda.equalsIgnoreCase("isbn")) {
			lista = repo.porAutor(textobusqueda);
	
		}else {
		lista = repo.buscarTodos();
	}

%>


	<form method="get">
		<select name="tipobusqueda">
			<option>titulo</option>
			<option>autor</option>
			<option>isbn</option>
		</select> 
		<input type="text" name="textobusqueda" /> <input type="submit" class="btn btn-warning" value="Buscar" />
	</form>


	<h1>Lista De Libros</h1>
	<table class="table table-striped table-hover">
		<caption>LIBROS</caption>
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
	</div>
</body>
</html>