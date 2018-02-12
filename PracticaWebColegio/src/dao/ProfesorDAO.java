package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Asignatura;
import beans.Profesor;

public class ProfesorDAO {

	// AÑADIR AL TOSTRING DE CURSO Y PROFESORES
	// EL BUSCAR SU LISTA DE ALUMNOS/ASIGNATURAS RELACIONADAS;

	// Añade un objeto profesor pasado por parametro a la base de datos
	public static void añadir(Profesor profesor) {

		String insert = "INSERT INTO profesores(nombre, apellidos, telefono, direccion, email, dni) VALUES ('"
				+ profesor.getNombre() + "', '" + profesor.getApellidos() + "', " + profesor.getTelefono() + ", '"
				+ profesor.getDireccion() + "', '" + profesor.getEmail() + "', " + profesor.getDni() + ")";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(insert);

			if (rs != 0)
				System.out.println(
						"Se ha añadido el profesor " + profesor.getNombre() + " " + profesor.getApellidos() + ".\n");

			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			System.out.println("El profesor " + profesor.getNombre() + " " + profesor.getApellidos() + " con DNI "
					+ profesor.getDni() + " ya existe.\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Busca un profesor en la base de datos a partir de su nombre y apellidos y lo
	// muestra por consola sus datos junto con las asignaturas que imparte
	public static Profesor buscar(String nombre, String apellidos) {

		String consulta = "SELECT * FROM profesores LEFT OUTER JOIN profesores_asignaturas ON profesores.dni = profesores_asignaturas.id_profesor LEFT OUTER JOIN asignaturas ON profesores_asignaturas.id_asignatura = asignaturas.id WHERE profesores.nombre='"
				+ nombre + "' AND profesores.apellidos='" + apellidos + "'";

		Profesor aux = null;
		String asignaturas = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			while (rs.next()) {
				aux = new Profesor(rs.getString("profesores.nombre"), rs.getString("apellidos"), rs.getInt("telefono"),
						rs.getString("direccion"), rs.getString("email"));
				asignaturas += rs.getString("asignaturas.nombre") + "; ";
			}

			rs.close();
			stm.close();
			con.close();

			System.out.println(aux.toString() + asignaturas + "\n");

		} catch (java.lang.NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("El profesor " + nombre + " " + apellidos + " no existe.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	// Busca un profesor en la base de datos a partir de su DNI y lo muestra por
	// consola sus datos junto con las asignaturas que imparte
	// El boolean pasado por parametro controla si imprime por consola
	public static Profesor buscar(Integer dni, boolean imprimir) {

		String consulta = "SELECT * FROM profesores LEFT OUTER JOIN profesores_asignaturas ON profesores.dni = profesores_asignaturas.id_profesor LEFT OUTER JOIN asignaturas ON profesores_asignaturas.id_asignatura = asignaturas.id WHERE profesores.dni="
				+ dni;

		Profesor aux = null;
		String asignaturas = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			while (rs.next()) {
				aux = new Profesor(rs.getString("profesores.nombre"), rs.getString("apellidos"), rs.getInt("telefono"),
						rs.getString("direccion"), rs.getString("email"));
				asignaturas += rs.getString("asignaturas.nombre") + "; ";
			}

			rs.close();
			stm.close();
			con.close();

			if (imprimir)
				System.out.println(aux.toString() + asignaturas + "\n");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			System.out.println("El profesor con DNI " + dni + " no existe.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	// Borra un profesor dado de alta a partir de su DNI, asi como sus relaciones
	// con las asignaturas que impartia
	public static void borrar(Integer dni) {

		String delete = "DELETE FROM profesores WHERE dni=" + dni;
		String delete2 = "DELETE FROM profesores_asignaturas WHERE dni =" + dni;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(delete);

			if (rs != 0)
				System.out.println("Se ha borrado el profesor con número de dni " + dni);
			else
				System.out.println("El profesor con numero de dni " + dni + " no existía de antemano.");

			stm.close();

			Statement stm2 = con.createStatement();
			int rs2 = stm.executeUpdate(delete2);

			if (rs2 == 0)
				System.out.println("El profesor tenia asignaturas relacionadas y se han borrado dichas relaciones.");

			stm2.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Modifica un profesor dado de alta en la base de datos buscandolo por su DNI,
	// y pasandole todos los nuevos valores por parámetros
	public static void modificar(Integer dni, String nombre, String apellidos, Integer telefono, String direccion,
			String email) {

		String consulta = "UPDATE profesores SET nombre='" + nombre + "', apellidos='" + apellidos + "', telefono="
				+ telefono + ", direccion='" + direccion + "', email='" + email + "' WHERE dni=" + dni;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(consulta);

			if (rs != 0) {
				System.out.println("El profesor con DNI " + dni + " se ha modificado correctamente.\n");
			} else
				System.out.println("El profesor con DNI " + dni + " no existe.\n");

			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Muestra por consola todos los profesores registrados en la base de datos
	// junto con las asignaturas correspondientes que imparten
	public static void mostrar() {

		String consulta = "SELECT * FROM profesores";
		String consulta2 = "SELECT * FROM asignaturas INNER JOIN profesores_asignaturas ON asignaturas.id=profesores_asignaturas.id_asignatura";

		String asignaturas = "";
		Profesor aux;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");

			Statement stm = con.createStatement();
			Statement stm2 = con.createStatement();

			ResultSet rs = stm.executeQuery(consulta);
			ResultSet rs2 = null;

			while (rs.next()) {

				aux = new Profesor(rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("telefono"),
						rs.getString("direccion"), rs.getString("email"));
				rs2 = stm2.executeQuery(consulta2);

				while (rs2.next()) {
					if (rs2.getInt("id_profesor") == aux.getDni()) {
						asignaturas = asignaturas + rs2.getString("asignaturas.nombre") + "; ";
					}
				}

				System.out.println(aux.toString() + asignaturas + "\n");
				asignaturas = "";

			}
			rs2.close();
			rs.close();
			stm2.close();
			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Añade una asignatura a un profesor a partir de sus identificadores
	public static void añadirAsignaturaAProfesor(Integer idAsignatura, Integer idProfesor) {

		Asignatura asignatura = AsignaturaDAO.buscar(idAsignatura, false);
		Profesor profesor = buscar(idProfesor, false);
		String insert = "INSERT INTO profesores_asignaturas(id_profesor, id_asignatura) VALUES (" + idProfesor + ", "
				+ idAsignatura + ")";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();

			if (asignatura != null && profesor != null) {
				int rs = stm.executeUpdate(insert);

				if (rs != 0)
					System.out.println("Se ha añadido la asignatura " + asignatura.getNombre() + " al profesor "
							+ profesor.getNombre() + ".\n");
			}

			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
