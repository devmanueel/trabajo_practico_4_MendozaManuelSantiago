package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;





public class ListadoAlumnos {
	public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	
	//metodo para listar todas las carreras
	public static List<Alumno> listarAlumnos(){
		if(alumnos.isEmpty()) {
			
			alumnos.add(new Alumno(42305122, "Manuel", "Mendoza", "manumendoza05@gmail.com", 388465121, LocalDate.parse("1999-12-26"), "AV: Jose Maria MB Barrio: Norte", "APU236" ,"alumno.png"));
			alumnos.add(new Alumno(42305122, "Joakin", "Gallardo", "joakinG@gmail.com", 388465111, LocalDate.parse("1998-02-02"), "Calle: Zafiro Barrio: Asuncion", "APU4233","alumno.png"));
			alumnos.add(new Alumno(42305122, "Rocio", "Guerrero", "RocioGuerrero05@gmail.com", 388465121, LocalDate.parse("1996-08-18"), "Calle: Amatista Barrio: Cuyaya", "APU4126","alumno.png"));
			
			
		}
		 return alumnos;
	}
	
	// Método para buscar un Alumno por LU
	  public static Alumno buscarAlumnoPorLu(String lu) {
	    for (Alumno a : alumnos) {
	      if (a.getLU().equals(lu)) {
	        return a;
	      }
	    }
	    return null;
	  }
	  

	  
	// Método para agregar un DOCENTE
	  public static void agregarAlumno(Alumno a) {
	    alumnos.add(a);
	    
	  }
	  
	// Método para modificar un Alumno
	  public static void modificarAlumno(Alumno alumnoModificado) {
	    for (int i = 0; i < alumnos.size(); i++) {
	      Alumno alumno = alumnos.get(i);
	      if (alumno.getLU().equals(alumnoModificado.getLU())) {
	        alumnos.set(i, alumnoModificado);
	        break;
	      }
	    }
	  }

	  // Método para eliminar un Alumno
	  public static void eliminarAlumno(String LU) {
	    alumnos.removeIf(alumno -> alumno.getLU().equals(LU));
	  }
}
