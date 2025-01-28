package es.cie.repositories;

import java.util.List;

import es.cie.negocio.LineaPrestamo;
import es.cie.negocio.Prestamo;

public interface PrestamoRepository {

	List<Prestamo> buscarTodos();
	void insertar(Prestamo prestamo);
	void borrar(Prestamo prestamo);
	List<Prestamo> buscarTodosOrdenados(String orden);
	List<LineaPrestamo> buscarLineas(int identificador);
}
