package es.cie.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.negocio.Prestamo;
import es.cie.repositories.PrestamoRepository;

public class PrestamoRepositoryJDBC implements PrestamoRepository {
	
	static final String DB_URL="jdbc:mysql://localhost:3306/bibliotecacie";
	static final String USER="root";
	static final String PASS="";

	@Override
	public List<Prestamo> buscarTodos() {
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		
		List<Prestamo> lista= new ArrayList<Prestamo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia= conexion.createStatement();
			rs= sentencia.executeQuery("select * from prestamos");
			
			while(rs.next()) {
				
				Prestamo p= new Prestamo(rs.getInt("identificador"),rs.getDate("fecha").toLocalDate(),rs.getInt("idejemplar"),rs.getInt("idcopia"));
				lista.add(p);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}

	@Override
	public void insertar(Prestamo prestamo) {
		Connection conexion=null;
		Statement sentencia=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia=conexion.createStatement();
			String insertarSql = "insert into prestamos values('"+prestamo.getIdentificador()+"','"+prestamo.getFecha()+"','"+prestamo.getIdejemplar()+"','"+prestamo.getIdcopia()+"')";
			
			System.out.println(insertarSql);
			
			sentencia.executeUpdate(insertarSql);
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar(Prestamo prestamo) {
		Connection conexion=null;
		Statement sentencia=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia=conexion.createStatement();
			String borraSql="delete from prestamos where identificador='"+prestamo.getIdentificador()+"'";
			
			System.out.println(borraSql);
			
			sentencia.executeUpdate(borraSql);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Prestamo> buscarTodosOrdenados(String orden) {
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		
		List<Prestamo> lista= new ArrayList<Prestamo>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia= conexion.createStatement();
			rs= sentencia.executeQuery("select * from prestamos order by "+orden);
			
			while(rs.next()) {
				
				Prestamo p= new Prestamo(rs.getInt("identificador"),rs.getDate("fecha").toLocalDate(),rs.getInt("idejemplar"),rs.getInt("idcopia"));
				lista.add(p);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	}


