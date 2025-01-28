package es.ascender.biblioteca.controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cie.negocio.LineaPrestamo;
import es.cie.negocio.Prestamo;
import es.cie.repositories.PrestamoRepository;
import es.cie.repositories.jdbc.PrestamoRepositoryJDBC;

@WebServlet("/PrestamosServlet")
public class PrestamosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrestamoRepository repo = new PrestamoRepositoryJDBC();
	List<Prestamo> lista = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("comando") == null) {

			if (request.getParameter("orden") != null) {
				lista = repo.buscarTodosOrdenados(request.getParameter("orden"));

			} else {
				lista = repo.buscarTodos();

			}
			request.setAttribute("lista", lista);
			RequestDispatcher despachador = request.getRequestDispatcher("listaprestamosjdbc.jsp");
			despachador.forward(request, response);

		} else {
			String comando = request.getParameter("comando");

			if (comando.equals("formularioprestamo")) {
				RequestDispatcher despachador = request.getRequestDispatcher("formularioprestamo.html");
				despachador.forward(request, response);

			} else if (comando.equals("salvarprestamo")) {
				int identificador = Integer.parseInt(request.getParameter("identificador"));
				String fechaTexto = request.getParameter("fecha");
				Calendar calendario = Calendar.getInstance();
				DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = null;
				try {
					fecha = formateador.parse(fechaTexto);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				calendario.setTime(fecha);

				Prestamo p = new Prestamo(identificador,
						fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				PrestamoRepository repo = new PrestamoRepositoryJDBC();
				repo.insertar(p);

				lista = repo.buscarTodos();

				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listaprestamosjdbc.jsp");
				despachador.forward(request, response);
				} 
			else if (comando.equals("borrarprestamo")) {
				
				int identificador = Integer.parseInt(request.getParameter("identificador"));

				Prestamo p = new Prestamo(identificador);
				PrestamoRepository repo = new PrestamoRepositoryJDBC();
				repo.borrar(p);

				lista = repo.buscarTodos();

				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listaprestamosjdbc.jsp");
				despachador.forward(request, response);
			
				
				
			}
		}
	List<LineaPrestamo> lista1=null;
	
	if (request.getParameter("comando") == null) {

		if (request.getParameter("buscarLineas") != null) {
			
			lista1 = repo.buscarLineas(Integer.parseInt(request.getParameter("identificador")));

		} else {

		}
		request.setAttribute("lista", lista1);
		RequestDispatcher despachador = request.getRequestDispatcher("listalineaprestamosjdbc.jsp");
		despachador.forward(request, response);

	
	}

}
}
