

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CursoDAO {

	// AÑADIR AL TOSTRING DE CURSO Y PROFESORES
	// EL BUSCAR SU LISTA DE ALUMNOS/ASIGNATURAS RELACIONADAS;

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

	// Añade un objeto Curso pasado por parametro a la base de datos
	public static void añadirCurso(Curso curso) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			PreparedStatement pstm = con
					.prepareStatement("INSERT INTO cursos(id, fecha_inicio, fecha_final, id_profesor, id_aula) "
							+ "VALUES(?, ?, ?, ?, ?)");

			pstm.setInt(1, curso.getId());
			pstm.setDate(2, java.sql.Date.valueOf(convertirDateAString(curso.getFechaInicio())));
			pstm.setDate(3, java.sql.Date.valueOf(convertirDateAString(curso.getFechaFinal())));
			pstm.setInt(4, curso.getProfesor().getDni());
			pstm.setInt(5, curso.getAula().getId());

			int rs = pstm.executeUpdate();

			if (rs != 0)
				System.out.println("El curso se ha añadido con éxito.");

			pstm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			System.out.println("El curso con DNI " + curso.getId() + " ya existe.\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Busca un objeto Curso a partir de su identificador en la base de datos
	// El boolean pasado por parametro controla si imprime por consola
	public static Curso buscar(Integer ID, boolean imprimir) {

		String consulta = "SELECT * FROM cursos LEFT OUTER JOIN cursos_alumnos ON cursos.id = cursos_alumnos.id_curso LEFT OUTER JOIN alumnos ON cursos_alumnos.id_alumno = alumnos.numMatricula WHERE cursos.id="
				+ ID;

		Curso aux = null;
		String alumnos = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);

			while (rs.next()) {
				aux = new Curso(ProfesorDAO.buscar(rs.getInt("id_profesor"), false),
						AulaDAO.buscar(rs.getInt("id_aula"), false), rs.getDate("fecha_inicio"),
						rs.getDate("fecha_final"));
				alumnos += rs.getString("alumnos.nombre") + "; ";
			}

			rs.close();
			stm.close();
			con.close();

			if (imprimir)
				System.out.println(aux.toString() + alumnos + "\n");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			System.out.println("El curso con identificador " + ID + " no existe.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	//
	public static void borrar() {

	}

	// NO FUNCIONA
	public static String buscarCursosActivos(String fechaString) throws Exception {

		Curso curso = null;
		String texto = "";
		Date fecha = sdf.parse(fechaString);

		if (curso.getFechaInicio().before(fecha) && curso.getFechaFinal().after(fecha)) {
			texto += curso.toString() + "\n";
		}

		System.out.println(texto);
		return texto;

	}

	// Imprime por consola la informacion de todos los cursos, junto con sus alumnos
	// correspondientes
	public static void mostrar() {

		String consulta = "SELECT * FROM cursos";
		String consulta2 = "SELECT * FROM cursos_alumnos INNER JOIN alumnos ON alumnos.numMatricula = cursos_alumnos.id_alumno";

		String alumnos = "";
		Curso aux;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");

			Statement stm = con.createStatement();
			Statement stm2 = con.createStatement();

			ResultSet rs = stm.executeQuery(consulta);
			ResultSet rs2 = null;

			while (rs.next()) {

				aux = new Curso(ProfesorDAO.buscar(rs.getInt("id_profesor"), false),
						AulaDAO.buscar(rs.getInt("id_aula"), false), rs.getDate("fecha_inicio"),
						rs.getDate("fecha_final"));

				rs2 = stm2.executeQuery(consulta2);

				while (rs2.next()) {
					if (rs2.getInt("id_curso") == aux.getId()) {
						alumnos = alumnos + rs2.getString("alumnos.nombre") + "; ";
					}
				}

				System.out.println(aux.toString() + alumnos + "\n");
				alumnos = "";

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

	// Convierte un objeto de tipo a Date a un String con un formato adecuado para
	// trabajar con el en la base de datos
	private static String convertirDateAString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String fecha = sdf.format(date);
		return fecha;
	}

	// Añade un alumno a un curso a partir de los identificadores de ambos,
	// comprobando si dicho alumno ya esta asignado a dicho curso
	public static void añadirAlumnoACurso(Integer idCurso, Integer idAlumno) {

		Curso curso = CursoDAO.buscar(idCurso, false);
		Alumno alumno = AlumnoDAO.buscar(idAlumno, false);
		String insert = "INSERT INTO cursos_alumnos(id_curso, id_alumno) VALUES (" + idCurso + ", " + idAlumno + ")";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
			Statement stm = con.createStatement();

			if (curso != null && alumno != null) {
				int rs = stm.executeUpdate(insert);

				if (rs != 0)
					System.out.println(
							"Se ha añadido el alumno " + alumno.getNombre() + " al curso " + curso.getId() + ".\n");
			} else
				System.out.println("Alguno de los datos está mal y no se encontró al alumno/curso.");

			stm.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			System.out.println("El alumno " + alumno.getNombre() + " " + alumno.getApellidos()
					+ " ya está asignado al curso " + curso.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
