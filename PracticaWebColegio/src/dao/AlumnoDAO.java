package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Alumno;

public class AlumnoDAO {

	// Añade un objeto alumno pasado por parametro a la base de datos
	public static void añadir(Alumno alumno) {

		String insert = "INSERT INTO alumnos(nombre, apellidos, telefono, direccion, email, numMatricula) VALUES ('"
				+ alumno.getNombre() + "', '" + alumno.getApellidos() + "', " + alumno.getTelefono() + ", '"
				+ alumno.getDireccion() + "', '" + alumno.getEmail() + "', " + alumno.getNumMatricula() + ")";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(insert);

			if (rs != 0)
				System.out.println("Se ha añadido el alumno " + alumno.getNombre() + " " + alumno.getApellidos() + ".");

			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			System.out.println("El alumno " + alumno.getNombre() + " " + alumno.getApellidos() + " con matricula "
					+ alumno.getNumMatricula() + " ya existe.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Busca un alumno en la base de datos a partir de su nombre y apellidos e
	// imprime todos us datos por consola
	public static Alumno buscar(String nombre, String apellidos) {

		String consulta = "SELECT * FROM alumnos WHERE nombre='" + nombre + "' AND apellidos='" + apellidos + "'";
		Alumno aux = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			if (rs.next()) {
				aux = new Alumno(rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("telefono"),
						rs.getString("direccion"), rs.getString("email"));
				System.out.println(aux.toString());
			} else
				System.out.println("El alumno '" + nombre + " " + apellidos + "' no existe.\n");

			rs.close();
			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;

	}

	// Busca un alumno en la base de datos a partir de su identificador e imprime
	// todos us datos por consola
	// El boolean pasado por parametro controla si imprime por consola
	public static Alumno buscar(Integer numMatricula, boolean imprimir) {

		String consulta = "SELECT * FROM alumnos WHERE numMatricula=" + numMatricula;
		Alumno aux = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			if (rs.next()) {
				aux = new Alumno(rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("telefono"),
						rs.getString("direccion"), rs.getString("email"));
				if (imprimir)
					System.out.println(aux.toString());
			} else
				System.out.println("El alumno con número de matrícula " + numMatricula + " no existe.\n");

			rs.close();
			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;

	}

	// Busca un alumno a partir de su identificador y lo elimina de la base de datos
	public static void borrar(Integer numMatricula) {

		String delete = "DELETE FROM alumnos WHERE numMatricula=" + numMatricula;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(delete);

			if (rs != 0)
				System.out.println("Se ha borrado el alumno con numero de matricula " + numMatricula);
			else
				System.out.println("El alumno con numero de matricula " + numMatricula + " no existía de antemano.");

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

	// Muestra por consola toda la informacion de todos los alumnos
	public static void mostrar() {

		Alumno aux;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM alumnos");

			while (rs.next()) {
				aux = new Alumno(rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("telefono"),
						rs.getString("direccion"), rs.getString("email"));
				System.out.println(aux);
			}

			rs.close();
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

	// Modifica un alumno dado de alta en la base de datos buscandolo por un numero
	// de matricula,
	// y pasandole todos los nuevos valores por parámetros
	public static void modificar(Integer numMatricula, String nombreNuevo, String apellidosNuevos,
			Integer telefonoNuevo, String direccionNueva, String emailNuevo) {

		String consulta = "UPDATE alumnos SET nombre='" + nombreNuevo + "', apellidos='" + apellidosNuevos
				+ "', telefono=" + telefonoNuevo + ", direccion='" + direccionNueva + "', email='" + emailNuevo
				+ "' WHERE numMatricula=" + numMatricula;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			int rs = stm.executeUpdate(consulta);

			if (rs != 0) {

				System.out.println(
						"El alumno con número de matrícula " + numMatricula + " se ha modificado correctamente.\n");
			} else
				System.out.println("El alumno con número de matrícula " + numMatricula + " no existe.\n");

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

	public static Alumno buscar(String s) {
		Alumno al=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stmt = conn.createStatement();
			

			// "SELECT * FROM alumnos WHERE nombre_apellidos = 'Jairo Muñoz' OR
			// numero_matricula = 99888777"

			String consulta = "SELECT * FROM alumnos WHERE ";
			try {
				Integer.parseInt(s);
				consulta = consulta + "numero_matricula = " + s;
			} catch (java.lang.NumberFormatException e) {
				String n = s.substring(0, s.indexOf(" "));
				String a = s.substring(s.indexOf(" "));
				consulta = consulta + "nombre='" + n + "' apellidos = '" + a + "'";
			}
			ResultSet rs = stmt.executeQuery(consulta);
			if (!rs.next()) {
				System.out.println("Alumno no encontrado.\n");
			} else {
				al.setNombre(rs.getString("nombre"));
				al.setApellidos(rs.getString("apellidos"));
				al.setDireccion(rs.getString("direccion"));
				al.setEmail(rs.getString("email"));
				al.setTelefono(Integer.parseInt(rs.getString("telefono")));
				al.setNumMatricula();
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver.\n");
		} catch (SQLException e) {
			System.out.println("Error de SQL.\n");
		}
		return al;
	}
}
