package es.cie.repositories;

import java.util.List;

import es.cie.negocio.Libro;

public interface LibroRepository {
	
	List<Libro> buscarTodos ();
	List<Libro> buscarPorAutor(String autor);
	List<Libro> porTitulo (String titulo);
	List<Libro> porOrden (String orden);
	void insertar (Libro libro);
	
	

}
