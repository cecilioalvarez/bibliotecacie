<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Lista DvdJDBC</title>
</head>
<body>

	<%

List<Dvd> lista=(list<Dvd>) request.getAttribute("lista");

%>
	<table>
		<thead>
			<tr>
				<th><a href="?orden=titulo">Titulo</a></th>
				<th><a href="?orden=anio">Año</a></th>
				<th><a href="?orden=disponible">Disponible</a></th>
				<th>borrar</th>
			</tr>
		</thead>

		<%
	for(Dvd d:lista){%>
		<tr>

			<td><%=d.getTitulo() %></td>
			<td><%=d.getAnio() %></td>
			<td><%=d.getDisponible() %></td>
			<td><a href="?comando=borrardvd&iddvd=<%d.getTitulo()%>">Borrar</a></td>
		</tr>

		<%} %>

	</table>

	<a href="?comando=dvdformulario">Insertar</a>
</body>
</html>