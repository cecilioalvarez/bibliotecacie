package es.cie.repositories;

import java.util.List;

import es.cie.negocio.Libro;

public interface LibroRepository {
	
	List<Libro> porAutor(Libro libro);
	List<Libro> porTitulo (Libro libro);
	List<Libro> porOrden (Libro orden);
	
	

}
