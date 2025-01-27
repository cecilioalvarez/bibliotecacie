package es.cie.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.negocio.Ejemplar;
import es.cie.repositories.EjemplarRepository;

public class EjemplarRepositoryJDBC implements EjemplarRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/bibliotecacie";
	static final String USER = "root";
	static final String PASS = "";

	public List<Ejemplar> buscarTodos() {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet rs = null;
		List<Ejemplar> lista = new ArrayList<Ejemplar>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			rs = sentencia.executeQuery("select * from ejemplar");
			while (rs.next()) {
				Ejemplar e = new Ejemplar(rs.getInt("id"), rs.getString("isbn"), rs.getString("titulo"),
						rs.getString("autor"), rs.getInt("paginas"));
				lista.add(e);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

	@Override
	public void insertar(Ejemplar ejemplar) {
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			String insertarsql = "insert into ejemplar values ('" + ejemplar.getId() + "','" + ejemplar.getIsbn()
					+ "','" + ejemplar.getTitulo() + "','" + ejemplar.getAutor() + "','" + ejemplar.getPaginas() + "')";
			System.out.println(insertarsql);
			sentencia.executeUpdate(insertarsql);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void borrar(Ejemplar ejemplar) {
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			String borrarsql = "delete from ejemplar where dni='" + ejemplar.getId() + "'";
			sentencia.executeUpdate(borrarsql);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modificar(Ejemplar ejemplar) {
		// TODO Auto-generated method stub
		
	}

}