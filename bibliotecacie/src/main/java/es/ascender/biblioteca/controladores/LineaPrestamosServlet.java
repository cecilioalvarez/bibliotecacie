package es.ascender.biblioteca.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cie.negocio.LineaPrestamo;
import es.cie.repositories.LineaPrestamoRepository;
import es.cie.repositories.jdbc.LineaPrestamoRepositoryJDBC;

@WebServlet("/LineaPrestamosServlet")
public class LineaPrestamosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LineaPrestamoRepository repo = new LineaPrestamoRepositoryJDBC();
	List<LineaPrestamo> lista = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("comando") == null) {

			if (request.getParameter("orden") != null) {
				lista = repo.buscarTodosOrdenados(request.getParameter("orden"));

			} else {
				lista = repo.buscarTodos();

			}
			request.setAttribute("lista", lista);
			RequestDispatcher despachador = request.getRequestDispatcher("listalineaprestamosjdbc.jsp");
			despachador.forward(request, response);
			
		}else{
				String comando = request.getParameter("comando");
				
				if (comando.equals("formulariolineaprestamo")) {
					RequestDispatcher despachador=request.getRequestDispatcher("formulariolineaprestamo.html");
					despachador.forward(request, response);
					
				}else if (comando.equals("salvarlineaprestamo")) {
					int identificador=Integer.parseInt(request.getParameter("identificador"));
					int identificadorlinea=Integer.parseInt(request.getParameter("identificadorlinea"));
					int idejemplar=Integer.parseInt(request.getParameter("idejemplar"));
					int idcopia=Integer.parseInt(request.getParameter("idcopia"));

					LineaPrestamo lp=new LineaPrestamo(identificador,identificadorlinea, idejemplar, idcopia);
					LineaPrestamoRepository repo=new LineaPrestamoRepositoryJDBC();
					repo.insertar(lp);
					
					lista = repo.buscarTodos();
					
					request.setAttribute("lista", lista);
					RequestDispatcher despachador = request.getRequestDispatcher("listalineaprestamosjdbc.jsp");
					despachador.forward(request, response);
				}else if(comando.equals("borrarlineaprestamo")) {
					int identificador=Integer.parseInt(request.getParameter("identificador"));
					int identificadorlinea=Integer.parseInt(request.getParameter("identificadorlinea"));

					LineaPrestamo lp=new LineaPrestamo(identificador, identificadorlinea);
					LineaPrestamoRepository repo=new LineaPrestamoRepositoryJDBC();
					repo.borrar(lp);
					
					lista = repo.buscarTodos();
					
					request.setAttribute("lista", lista);
					RequestDispatcher despachador = request.getRequestDispatcher("listalineaprestamosjdbc.jsp");
					despachador.forward(request, response);
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
