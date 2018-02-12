package beans;

public class Alumno {
	
	private String nombre;
	private String apellidos;
	private int telefono;
	private String direccion;
	private String email;
	private Integer numMatricula;
	
	//Constructor pasando todos los parámetros
	public Alumno(String nombre, String apellidos, int telefono, String direccion, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.numMatricula = hashCode();
	}
	
	public String toString(){
		
		String texto = 	"\nNombre:\t\t" + getNombre() +
						"\nApellidos:\t" + getApellidos() +
						"\nTelefono:\t" + getTelefono() + 
						"\nDireccion:\t" + getDireccion() + 
						"\nEmail:\t\t" + getEmail() +
						"\nMatrícula:\t" + getNumMatricula() + "\n"; 
		
		return texto;
	}
	
	//Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumMatricula() {
		return numMatricula;
	}
	public void setNumMatricula() {
		this.numMatricula = hashCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + telefono;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Alumno other = (Alumno) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		
		if (numMatricula == null) {
			if (other.numMatricula != null)
				return false;
		} else if (!numMatricula.equals(other.numMatricula))
			return false;
		
		return true;
	}

}
