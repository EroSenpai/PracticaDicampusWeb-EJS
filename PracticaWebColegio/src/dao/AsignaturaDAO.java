package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Alumno;
import beans.Asignatura;

public class AsignaturaDAO {
	
	private static final String DATA_SOURCE_NAME = "jdbc/colegio";
	
	// Añade un objeto asignatura pasado por parametro a la base de datos
	public static void añadir(Asignatura asignatura) {

		String insert = "INSERT INTO asignaturas(nombre, num_creditos, max_alumnos, id) VALUES ('"
				+ asignatura.getNombre() + "', " + asignatura.getNumCreditos() + ", " + asignatura.getMaxAlumnos()
				+ ", " + asignatura.getId() + ")";

		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(insert);

			if (rs != 0)
				System.out.println("Se ha añadido la asignatura " + asignatura.getNombre() + ".");

			stm.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			System.out.println("La asignatura " + asignatura.getNombre() + " ya existe.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Busca una asignatura en la base de datos a partir del nombre e imprime por
	// consola sus datos
/*	public static Asignatura buscar(String nombre) {

		String consulta = "SELECT * FROM asignaturas WHERE nombre='" + nombre + "'";
		Asignatura aux = null;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			if (rs.next()) {
				aux = new Asignatura(rs.getString("nombre"), rs.getInt("num_creditos"), rs.getInt("max_alumnos"));
				System.out.println(aux.toString());
			} else
				System.out.println("La asignatura '" + nombre + "' no existe.\n");

			rs.close();
			stm.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
*/

	// Busca una asignatura en la base de datos a partir del identificador e imprime
	// por consola sus datos
	// El boolean pasado por parametro controla si imprime por consola
	public static Asignatura buscar(Integer id, boolean imprimir) {

		String consulta = "SELECT * FROM asignaturas WHERE id=" + id;
		Asignatura aux = null;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			if (rs.next()) {
				aux = new Asignatura(rs.getString("nombre"), rs.getInt("num_creditos"), rs.getInt("max_alumnos"));
				if (imprimir)
					System.out.println(aux.toString());
			} else {
				System.out.println("La asignatura con identificador " + id + " no existe.\n");
			}
			rs.close();
			stm.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	// Borra una asignatura directamente en la base de datos a partir de su
	// identificador
	public static void borrar(Integer id) {

		String delete = "DELETE FROM asignaturas WHERE id=" + id;

		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(delete);

			if (rs != 0)
				System.out.println("Se ha borrado la asignatura con identificador " + id);
			else
				System.out.println("La asignatura con identificador " + id + " no existía de antemano.");

			stm.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Muestra por consola toda la informacion de todas las asignaturas
	public static void mostrar() {

		Asignatura aux;

		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM asignaturas");

			while (rs.next()) {
				aux = new Asignatura(rs.getString("nombre"), rs.getInt("num_creditos"), rs.getInt("max_alumnos"));
				System.out.println(aux);
			}

			rs.close();
			stm.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Modifica una asignatura dada de alta en la base de datos buscandola por su
	// ID, y pasandole todos los nuevos valores por parámetros
	public static void modificar(Integer ID, String nombre, Integer numCreditos, Integer maxAlumnos) {

		String consulta = "UPDATE asignaturas SET nombre='" + nombre + "', num_creditos=" + numCreditos
				+ ", max_alumnos=" + maxAlumnos + " WHERE id=" + ID;

		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(consulta);

			if (rs != 0) {

				System.out.println("La asignatura con identificador " + ID + " se ha modificado correctamente.\n");
			} else
				System.out.println("La asignatura con identificador " + ID + " no existe.\n");

			stm.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//BUSCA TANTO POR NOMBRE COMO POR IDENTIFICADOR
	public static Asignatura buscar(String s) {

		Asignatura asig = null;
		
		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stmt = con.createStatement();
			

			// "SELECT * FROM alumnos WHERE nombre_apellidos = 'Jairo Muñoz' OR
			// numero_matricula = 99888777"

			String consulta = "SELECT * FROM asignaturas WHERE ";
			try {
				Integer.parseInt(s);
				consulta = consulta + "id = " + s;
			} catch (java.lang.NumberFormatException e) {
				String n = s.substring(0, s.indexOf(" "));
				consulta = consulta + "nombre='" + n + "'";
			}
			ResultSet rs = stmt.executeQuery(consulta);
			if (!rs.next()) {
				System.out.println("Asignatura no encontrada.\n");
			} else {
				asig.setNombre(rs.getString("nombre"));
				asig.setNumCreditos(Integer.parseInt(rs.getString("num_creditos")));
				asig.setMaxAlumnos(Integer.parseInt(rs.getString("max_alumnos")));
				asig.setId();
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (NamingException e) {
			System.out.println("No se ha encontrado el driver.\n");
		} catch (SQLException e) {
			System.out.println("Error de SQL.\n");
		}
		return asig;
	}
}
