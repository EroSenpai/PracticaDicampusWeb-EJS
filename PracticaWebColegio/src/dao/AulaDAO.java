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
import beans.Aula;

public class AulaDAO {
	
	private static final String DATA_SOURCE_NAME = "jdbc/colegio";
	
	// Añade un objeto aula pasado por parámetro a la base de datos
	public static void añadir(Aula aula) {

		String insert = "INSERT INTO aulas(nombre, capacidad, id) VALUES ('" + aula.getNombre() + "', "
				+ aula.getCapacidad() + ", " + aula.getId() + ")";

		try {
			
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(insert);

			if (rs != 0)
				System.out.println("Se ha añadido el aula '" + aula.getNombre() + "'.");

			stm.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			System.out.println("El aula '" + aula.getNombre() + "' con identificador " + aula.getId() + " ya existe.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Busca un aula a partir de su identificador e imprime por consola sus datos
	// El boolean pasado por parametro controla si imprime por consola
	public static Aula buscar(Integer ID, boolean imprimir) {

		String consulta = "SELECT * FROM aulas WHERE id=" + ID;
		Aula aux = null;

		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			if (rs.next()) {
				aux = new Aula(rs.getString("nombre"), rs.getInt("capacidad"), rs.getInt("id"));
				if (imprimir)
					System.out.println(aux.toString());
			} else
				System.out.println("El aula con identificador " + ID + " no existe.\n");

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

	// Borra una asignatura directamente de la base de datos a partir de su
	// identificador
	public static void borrar(Integer id) {

		String delete = "DELETE FROM aulas WHERE id=" + id;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(delete);

			if (rs != 0)
				System.out.println("Se ha borrado el aula con identificador " + id);
			else
				System.out.println("El aula con identificador " + id + " no existía de antemano.");

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

	// Muestra por consola toda la informacion de todas las aulas
	public static void mostrar() {

		Aula aux;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM aulas");

			while (rs.next()) {
				aux = new Aula(rs.getString("nombre"), rs.getInt("capacidad"), rs.getInt("id"));
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

	// Modifica un aula dada de alta en la base de datos buscandola por su ID, y
	// pasandole todos los nuevos valores por parámetros
	public static void modificar(Integer ID, String nombre, Integer capacidad) {

		String consulta = "UPDATE aulas SET nombre='" + nombre + "', capacidad=" + capacidad + " WHERE id=" + ID;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:com/env");
			DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
			Connection con = dataSource.getConnection();
			
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(consulta);

			if (rs != 0) {
				System.out.println("El aula con identificador " + ID + " se ha modificado correctamente.\n");
			} else
				System.out.println("El aula con identificador " + ID + " no existe.\n");

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

	//METODO ACTUAL DE BUSQUEDA
		public static Aula buscar(String s) {
			
			Aula au = null;
			
			try {

				Context initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:com/env");
				DataSource dataSource = (DataSource) envCtx.lookup(DATA_SOURCE_NAME);
				Connection con = dataSource.getConnection();
				
				Statement stmt = con.createStatement();
				

				// "SELECT * FROM alumnos WHERE nombre_apellidos = 'Jairo Muñoz' OR
				// numero_matricula = 99888777"

				String consulta = "SELECT * FROM aulas WHERE ";
				try {
					Integer.parseInt(s);
					consulta = consulta + "id = " + s;
				} catch (java.lang.NumberFormatException e) {
					String n = s.substring(0, s.indexOf(" "));
					consulta = consulta + "nombre='" + n + "'";
				}
				ResultSet rs = stmt.executeQuery(consulta);
				if (!rs.next()) {
					System.out.println("Aula no encontrada.\n");
				} else {
					au.setNombre(rs.getString("nombre"));
					au.setCapacidad(Integer.parseInt(rs.getString("capacidad")));
					au.setId();
				}
				rs.close();
				stmt.close();
				con.close();
			} catch (NamingException e) {
				System.out.println("No se ha encontrado el driver.\n");
			} catch (SQLException e) {
				System.out.println("Error de SQL.\n");
			}
			return au;
		}
}
