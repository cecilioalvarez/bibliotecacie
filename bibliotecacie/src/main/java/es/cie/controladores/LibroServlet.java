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

/**
 * Servlet implementation class LibroServlet
 */
@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    LibroRepository repo= new LibroRepositoryJDBC();
    List <Libro> lista=repo.buscarTodos();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("comando")==null) {
			

			if(request.getParameter("orden")!=null){
				//out.println("Jerarquía a base de "+request.getParameter("orden"));
				lista=repo.porOrden(request.getParameter("orden"));
			}else 
				lista=repo.buscarTodos();
		}
		
		request.getAttribute("lista",lista);
		RequestDispatcher despachador = request.getRequestDispatcher("buscadorlibrojdbc.jsp");
	
		despachador.forward(request, response);
	}else {
		String comando=request.getParameter("comando");
		if(comando.equals("formulario")) {
			
			String isbn= request.getParameter("isbn");
			String titulo=request.getParameter("titulo");
			String autor=request.getParameter("autor");
			int paginas=request.getParameter("paginas");
			
			Libro l=new Libro(isbn,titulo,autor,paginas);
			LibroRepository repo=new LibroRepositoryJDBC();
			repo.insertar (l);
			
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
