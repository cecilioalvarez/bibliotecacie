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

		if (request.getParameter("comando") == null) {

			if (request.getParameter("orden") != null) {
				lista = repo.buscarTodosOrdenados(request.getParameter("orden"));

			} else {
				lista = repo.buscarTodos();
			}
			request.setAttribute("lista", lista);
			RequestDispatcher despachador = request.getRequestDispatcher("listaejemplarJDBC.jsp");
			despachador.forward(request, response);

		} else {
			String comando = request.getParameter("comando");
			if (comando.equals("formularioejemplar")) {

				RequestDispatcher despachador = request.getRequestDispatcher("formularioejemplar.html");
				despachador.forward(request, response);

			} else if (comando.equals("salvarejemplar")) {

				// int id = Integer.parseInt(request.getParameter("id"));
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");

				Ejemplar e = new Ejemplar(isbn, titulo, autor);
				EjemplarRepository repo = new EjemplarRepositoryJDBC();
				repo.insertar(e);
				lista = repo.buscarTodos();

				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listaejemplarJDBC.jsp");
				despachador.forward(request, response);
				response.sendRedirect("listaejemplarJDBC.jsp");

			} else if (comando.equals("borrarejemplar")) {

				int id = Integer.parseInt(request.getParameter("id"));

				Ejemplar e = new Ejemplar(id);
				EjemplarRepository repo = new EjemplarRepositoryJDBC();
				repo.borrar(e);
				lista = repo.buscarTodos();

				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listaejemplarJDBC.jsp");
				despachador.forward(request, response);
			}

		}

	}

}
