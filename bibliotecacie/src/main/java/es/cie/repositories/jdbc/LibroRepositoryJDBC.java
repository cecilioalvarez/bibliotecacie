package es.cie.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.negocio.Libro;
import es.cie.repositories.LibroRepository;

public class LibroRepositoryJDBC implements LibroRepository{
	
	String cadenaconexion= "jdbc:mysql://localhost:3306/bibliotecacie";
	List<Libro> lista = new ArrayList<Libro> ();
	
	
	@Override
	public List<Libro> buscarTodos() {
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
			Statement sentencia = conexion.createStatement();) {
		ResultSet rs = sentencia.executeQuery("select * from libro");

		while (rs.next()) {
			Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"),
					rs.getInt("paginas"));
			lista.add(l);
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	return lista;
	}
	

	
	
	
	@Override
	public List<Libro> porAutor(Libro libro) {
		try (Connection conexion= DriverManager.getConnection(cadenaconexion, "root","");
				Statement sentencia = conexion.createStatement();){
			ResultSet rs = sentencia.executeQuery("select * from libro where autor= '"+libro.getAutor()+"'");
			while (rs.next()) {
				Libro l = new Libro (rs.getString("autor"));
				lista.add(l);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		return lista;
	}
	@Override
	public List<Libro> porTitulo(Libro libro) {
		try (Connection conexion= DriverManager.getConnection(cadenaconexion, "root","");
				Statement sentencia = conexion.createStatement();){
			ResultSet rs = sentencia.executeQuery("select * from libro where titulo= '"+libro.getTitulo()+"'");
			while (rs.next()) {
				Libro l = new Libro (rs.getString("titulo"));
				lista.add(l);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		return lista;
	}
	@Override
	public List<Libro> porOrden (Libro orden){
	try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
			Statement sentencia = conexion.createStatement();) {
		ResultSet rs = sentencia.executeQuery("select * from libro order by"+orden);

		while (rs.next()) {
			Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"),
					rs.getInt("paginas"));
			lista.add(l);
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}

	return lista;
}
	
	
	
	

}
