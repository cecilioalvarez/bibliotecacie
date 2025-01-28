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

public class LibroRepositoryJDBC implements LibroRepository {

	String cadenaconexion = "jdbc:mysql://localhost:3306/bibliotecacie";
	

	@Override
	public List<Libro> buscarTodos() {

		List<Libro> lista = new ArrayList<Libro>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from libro");

			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("paginas"));
				lista.add(l);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public List<Libro> buscarPorAutor(String autor) {
		List<Libro> lista = new ArrayList<Libro>();
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
				Statement sentencia = conexion.createStatement();) {
			ResultSet rs = sentencia.executeQuery("select * from libro where autor= '" + autor + "'");
			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("paginas"));
				lista.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public List<Libro> buscarPorTitulo(String titulo) {
		List<Libro> lista = new ArrayList<Libro>();
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
				Statement sentencia = conexion.createStatement();) {
			ResultSet rs = sentencia.executeQuery("select * from libro where titulo= '" + titulo + "'");
			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("paginas"));
				lista.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public List<Libro> porOrden(String orden) {
		List<Libro> lista = new ArrayList<Libro>();
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
				Statement sentencia = conexion.createStatement();) {
			ResultSet rs = sentencia.executeQuery("select * from libro order by" + orden);

			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("paginas"));
				lista.add(l);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

	public void insertar(Libro libro) {

		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
				Statement sentencia = conexion.createStatement();) {

			String insertarSql = "insert into libro values ('" + libro.getIsbn() + "','" + libro.getTitulo() + "','"
					+ libro.getAutor() + "','" + libro.getPaginas() + "')";
			System.out.println(insertarSql);
			sentencia.executeUpdate(insertarSql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
