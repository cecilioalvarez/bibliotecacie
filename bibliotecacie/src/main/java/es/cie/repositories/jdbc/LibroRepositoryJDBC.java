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
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/bibliotecacie";
	static final String USER = "root";
	static final String PASS = "";
	
	
	@Override
	public List<Libro> buscarTodos() {
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		List<Libro> lista= new ArrayList<Libro>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia=conexion.createStatement();
			rs=sentencia.executeQuery("select * from libro");
			
			while(rs.next()) {
				Libro l= new Libro(rs.getString("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("paginas"));
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
		
		
	}

	@Override
	public void borrar(Libro libro) {
		
		
	}

	@Override
	public void modificar(Libro libro) {
		
		
	}

	@Override
	public List<Libro> buscarTodosOrdenados(String orden) {
		
		return null;
	}


}