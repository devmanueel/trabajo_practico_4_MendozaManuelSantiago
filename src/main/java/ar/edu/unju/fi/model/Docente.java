package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Docente {
	
	private String legajo;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String foto;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public Docente(String legajo, String nombre, String apellido, String email, int telefono, String foto) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.foto = foto;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
