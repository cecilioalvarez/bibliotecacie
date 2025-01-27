package es.cie.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.negocio.LineaPrestamo;
import es.cie.negocio.Prestamo;
import es.cie.repositories.LineaPrestamoRepository;

public class LineaPrestamoRepositoryJDBC implements LineaPrestamoRepository {
	
	static final String DB_URL="jdbc:mysql://localhost:3306/bibliotecacie";
	static final String USER="root";
	static final String PASS="";

	@Override
	public List<LineaPrestamo> buscarTodos() {
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		
		List<LineaPrestamo> lista= new ArrayList<LineaPrestamo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia= conexion.createStatement();
			rs= sentencia.executeQuery("select * from lineaprestamos");
			
			while(rs.next()) {
				
				LineaPrestamo lp= new LineaPrestamo(rs.getInt("identificador"),rs.getInt("identificadorlinea"),rs.getInt("idejemplar"),rs.getInt("idcopia"));
				lista.add(lp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}

	@Override
	public void insertar(LineaPrestamo lineaprestamo) {
		Connection conexion=null;
		Statement sentencia=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia=conexion.createStatement();
			String insertarSql = "insert into lineaprestamos values('"+lineaprestamo.getIdentificador()+"','"+lineaprestamo.getIdentificadorlinea()+"','"+lineaprestamo.getIdejemplar()+"','"+lineaprestamo.getIdcopia()+"')";
			
			System.out.println(insertarSql);
			
			sentencia.executeUpdate(insertarSql);
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar (LineaPrestamo lineaprestamo) {
		Connection conexion=null;
		Statement sentencia=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia=conexion.createStatement();
			String borraSql="delete from lineaprestamos where identificador='"+lineaprestamo.getIdentificador()+"'&identificadorlinea='"+lineaprestamo.getIdentificadorlinea()+"'";
			
			System.out.println(borraSql);
			
			sentencia.executeUpdate(borraSql);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<LineaPrestamo> buscarTodosOrdenados(String orden) {
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		
		List<LineaPrestamo> lista= new ArrayList<LineaPrestamo>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia= conexion.createStatement();
			rs= sentencia.executeQuery("select * from lineaprestamos order by "+orden);
			
			while(rs.next()) {
				
				LineaPrestamo lp= new LineaPrestamo(rs.getInt("identificador"),rs.getInt("identificadorlinea"),rs.getInt("idejemplar"),rs.getInt("idcopia"));
				lista.add(lp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	}


