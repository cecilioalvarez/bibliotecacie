<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="es.cie.negocio.LineaPrestamo" %>
<%@page import="java.util.List"%>
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
<div class="container">
	<h1>Lista Linea Prestamos</h1>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

<%
List<LineaPrestamo> lista=(List<LineaPrestamo>) request.getAttribute("lista");%>

	<div class="container">
		<table class="table table-striped table-hover">
			<thead>
				<tr class="table-danger">
					<th><a href="?orden=identificador">Identificador</th>
					<th><a href="?orden=identificadorlinea">Identificador Linea</th>
					<th><a href="?orden=idejemplar">Id Ejemplar</th>
					<th><a href="?orden=idcopia">Id Copia</th>
							
												
					<th>Borrar</th>
				</tr>
			</thead>
			<%
			for (LineaPrestamo lp : lista) {
			%>
				<tr>
					<td><%=lp.getIdentificador()%></td>
					<td><%=lp.getIdentificadorlinea()%></td>
					<td><%=lp.getIdejemplar()%></td>
					<td><%=lp.getIdcopia()%></td>
					
					
					<td><a href="?comando=borrarlineaprestamo&identificador=<%=lp.getIdentificador()%>&identificadorlinea=<%=lp.getIdentificadorlinea()%>">borrar</a></td>
				</tr>
			<%
			}
			%>
				
		</table>

	</div>
	<div class="container">
	<a href="?comando=formulariolineaprestamo">insertar</a>
	</div>

</body>
</html>