package es.cie.repositories;

import java.util.List;

import es.cie.negocio.Libro;

public interface LibroRepository {
	
	List<Libro> buscarTodos();
	void insertar(Libro libro);
	void borrar (Libro libro);
	void modificar (Libro libro);
	List <Libro> buscarTodosOrdenados (String orden);

}
