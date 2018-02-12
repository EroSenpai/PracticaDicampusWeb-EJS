package beans;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import dao.CursoDAO;

public class Curso {

	private int id;
	private Date fechaInicio;
	private Date fechaFinal;
	private Profesor profesor;
	private Aula aula;

	public Curso() {

	}

	// Constructor pasando todos los parámetros
	public Curso(Profesor profesor, Aula aula, Date fechaInicio, Date fechaFinal) {
		this.profesor = profesor;
		this.aula = aula;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.id = hashCode();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((fechaFinal == null) ? 0 : fechaFinal.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		return result;
	}

	public String toString() {

		String texto = "";
		try {
			texto = "ID:\t\t" + getId() + "\nFecha Inicio:\t" + CursoDAO.sdf.format(getFechaInicio())
					+ "\nFecha Final:\t" + CursoDAO.sdf.format(getFechaFinal()) + "\nProfesor:\t"
					+ getProfesor().getNombre() + " " + getProfesor().getApellidos() + "\nAula:\t\t"
					+ getAula().getNombre() + "\nAlumnos:\t";

		} catch (Exception e) {

		}
		return texto;
	}
}
