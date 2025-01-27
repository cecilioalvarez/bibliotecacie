package es.cie.repositories;

import java.util.List;

import es.cie.negocio.LineaPrestamo;
import es.cie.negocio.Prestamo;

public interface LineaPrestamoRepository {

	List<LineaPrestamo> buscarTodos();
	void insertar(LineaPrestamo lineaprestamo);
	void borrar(LineaPrestamo lineaprestamo);
	List<LineaPrestamo> buscarTodosOrdenados(String orden);
}
