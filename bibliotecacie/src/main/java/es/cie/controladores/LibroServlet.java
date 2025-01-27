package es.cie.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cie.negocio.Libro;
import es.cie.repositories.LibroRepository;
import es.cie.repositories.jdbc.LibroRepositoryJDBC;

@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	LibroRepository repo = new LibroRepositoryJDBC();
	List<Libro> lista = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("comando") == null) {

			if (request.getParameter("orden") != null) {
				lista = repo.buscarTodosOrdenados(request.getParameter("orden"));

			} else {
				lista = repo.buscarTodos();
			}
			request.setAttribute("lista", lista);
			RequestDispatcher despachador = request.getRequestDispatcher("listalibroJDBC.jsp");
			despachador.forward(request, response);

		} else {
			String comando = request.getParameter("comando");
			if (comando.equals("formulariolibro")) {

				RequestDispatcher despachador = request.getRequestDispatcher("formulariolibro.html");
				despachador.forward(request, response);

			} else if (comando.equals("salvarlibro")) {

				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int paginas = Integer.parseInt(request.getParameter("paginas"));

				Libro l = new Libro(isbn, titulo, autor, paginas);
				LibroRepository repo = new LibroRepositoryJDBC();
				repo.insertar(l);
				lista = repo.buscarTodos();

				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listalibroJDBC.jsp");
				despachador.forward(request, response);

			} else if (comando.equals("borrarlibro")) {

				String isbn = request.getParameter("isbn");

				Libro l = new Libro(isbn);
				LibroRepository repo = new LibroRepositoryJDBC();
				repo.borrar(l);
				lista = repo.buscarTodos();

				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listalibroJDBC.jsp");
				despachador.forward(request, response);
			}

		}

	}

	
	}
