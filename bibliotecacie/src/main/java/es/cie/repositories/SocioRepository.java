package es.cie.repositories;

import java.util.List;
import es.cie.negocio.Socio;

public interface SocioRepository {

	List<Socio> buscarTodos();
	void insertar(Socio socio);
	void borrar(Socio socio);
	List<Socio> buscarTodosOrdenados(String orden);
	
}
