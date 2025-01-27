package es.cie.repositories;

import java.util.List;


import es.cie.negocio.Libro;

public interface LibroRepository {
	
	List<Libro> buscarTodos ();
	List<Libro> porAutor(String libro);
	List<Libro> porTitulo (String libro);
	List<Libro> porOrden (String orden);
	void insertar (Libro libro);
	
	

}
