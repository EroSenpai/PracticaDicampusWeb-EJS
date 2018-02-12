

public class Asignatura {
	
	private String nombre;
	private int numCreditos;
	private int maxAlumnos;
	private int id;
	
	//Constructor pasando todos los parámetros
	public Asignatura(String nombre, int numCreditos, int maxAlumnos) {
		this.nombre = nombre;
		this.numCreditos = numCreditos;
		this.maxAlumnos = maxAlumnos;
		this.id = this.hashCode();
		
	}
	
	//Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumCreditos() {
		return numCreditos;
	}
	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}
	public int getMaxAlumnos() {
		return maxAlumnos;
	}
	public void setMaxAlumnos(int maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = hashCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxAlumnos;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numCreditos;
		return result;
	}
	
	public String toString(){
		
		String texto = 	"Nombre:\t\t" + getNombre() +
						"\nNúm.Créditos:\t" + getNumCreditos() +
						"\nMáx.Alumnos:\t" + getMaxAlumnos() + 
						"\nID:\t\t" + getId() + "\n"; 
		
		return texto;
	}
	
	
}

