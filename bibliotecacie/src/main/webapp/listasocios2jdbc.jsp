<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.cie.negocio.Socio"%>
<%@ page
	import="es.cie.repositories.jdbc.SocioRepositoryJDBC"%>
<%@ page import="es.cie.repositories.SocioRepository"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<%

	SocioRepository repo = new SocioRepositoryJDBC();
	List<Socio> lista=null;
	
	
	
	if (request.getParameter("orden")!=null) {
		
		out.println("ordenado por  "+ request.getParameter("orden"));
		lista=repo.buscarTodosOrdenados(request.getParameter("orden"));
	}else {
		
		out.println("no hay orden");
		lista=repo.buscarTodos();
	}
	

	%>
<div class="container">
	<table>
	<thead>
		<tr class="table-primery">
		<th><a href="?orden=dni">Dni</a></th>
		<th><a href="?orden=nombre">Nombre</a></th>
		<th><a href="?orden=apellidos">Apellidos</a></th>
		<th>Borrar</th>
		</tr>
		<%for (Socio s:lista) {%>
		<tr>
			<!-- una columna o celda  -->
			<td><%=s.getDni()%></td>
			<td><%=s.getNombre()%></td>
			<td><%=s.getApellidos()%></td>
			<td><a href="borrarsociojdbc.jsp?dni=<%=s.getDni()%>">borrar</a></td>
		</tr>
		<%} %>
	</thead>	
	</table>
<!-- ancla es un enlace a otra pagina -->
<!-- lleva una propiedad href con la pagina de destino y un texto -->
<a href="?comando=formulariosocio">insertar</a>
</div>





</body>
</html>