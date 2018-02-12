
public class Aula {

	private String nombre;
	private int capacidad;
	private int id;

	// Constructor pasando todos los parámetros
	public Aula(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.id = this.hashCode();
	}

	// Constructor pasando todos los parámetros
	public Aula(String nombre, int capacidad, int id) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.id = id;
	}

	// Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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
		result = prime * result + capacidad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public String toString() {

		String texto = "\nNombre:\t\t" + getNombre() + 
						"\nCapacidad:\t" + getCapacidad() + 
						"\nIdentificador:\t" + getId();
		return texto;
	}

}
