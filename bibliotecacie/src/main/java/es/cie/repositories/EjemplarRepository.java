package es.cie.repositories;

import java.util.List;

import es.cie.negocio.Ejemplar;
import es.cie.repositories.EjemplarRepository;

public interface EjemplarRepository {

	List<Ejemplar> buscarTodos();

	void insertar(Ejemplar ejemplar);

	void borrar(Ejemplar ejemplar);

	void modificar(Ejemplar ejemplar);
}