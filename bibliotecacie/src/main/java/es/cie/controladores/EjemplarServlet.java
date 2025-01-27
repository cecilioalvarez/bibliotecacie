package es.cie.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cie.negocio.Ejemplar;
import es.cie.repositories.EjemplarRepository;
import es.cie.repositories.jdbc.EjemplarRepositoryJDBC;

@WebServlet("/EjemplarServlet")
public class EjemplarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EjemplarRepository repo = new EjemplarRepositoryJDBC();
	List<Ejemplar> lista = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		lista = repo.buscarTodos();

		request.setAttribute("lista", lista);
		RequestDispatcher dp = request.getRequestDispatcher("listaejemplarjdbc.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}