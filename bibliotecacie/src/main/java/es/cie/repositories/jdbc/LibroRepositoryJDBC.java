package es.cie.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.negocio.Ejemplar;
import es.cie.negocio.Libro;
import es.cie.repositories.LibroRepository;

public class LibroRepositoryJDBC implements LibroRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/bibliotecacie";
	static final String USER = "root";
	static final String PASS = "";

	@Override
	public List<Libro> buscarTodos() {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet rs = null;
		List<Libro> lista = new ArrayList<Libro>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			rs = sentencia.executeQuery("select * from libro");

			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("paginas"));
				lista.add(l);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void insertar(Libro libro) {
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			String insertarsql = "insert into libro values ('" + libro.getIsbn() + "','" + libro.getTitulo() + "','"
					+ libro.getAutor() + "','" + libro.getPaginas() + "')";
			sentencia.executeUpdate(insertarsql);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void borrar(Libro libro) {
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			String borrarsql = "delete from libro where isbn='" + libro.getIsbn() + "'";
			sentencia.executeUpdate(borrarsql);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Libro> buscarTodosOrdenados(String orden) {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet rs = null;
		List<Libro> lista = new ArrayList<Libro>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			rs = sentencia.executeQuery("select * from libro order by " + orden);
			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("paginas"));
				lista.add(l);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

}