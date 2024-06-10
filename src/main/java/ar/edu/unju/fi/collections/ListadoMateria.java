package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

public class ListadoMateria {
	
	public static List<Materia> materias = new ArrayList<Materia>();
	
	
	//metodo para listar todas las MATERIAS
	
	
	public static List<Materia> listarMaterias(){

		if(materias.isEmpty()) {
			//carreras.add(new Carrera("cod01", "A.P.U", 5 , true));
			
			  
			  Docente docente = new Docente("n1", "Juan Carlos", "Rodriguez", "JuanCarlos@gmail.com", 388982233,"JCR.png");
		      Carrera carrera = new Carrera("cod01", "A.P.U", 5 , true);

		        
			materias.add(new Materia("cod01", "Programacion Visual", "Aula03", 80,Modalidad.VIRTUAL, docente , carrera));
			
		}
		   
		 return materias;

	}
	
	
	public static Materia buscarMateriaPorCodigo(String codigo) {
	    for (Materia m : materias) {
	      if (m.getCodigo().equals(codigo)) {
	        return m;
	      }
	    }
	    return null;
	  }
	

	 // Método para agregar una materia
	  public static void agregarMateria(Materia m) {
		//agregando el estado
		  //c.setEstado(true); 
		  materias.add(m);
	  }	
	
	// Método para modificar una carrera
	  public static void modificarMateria(Materia materiaModificada) {
		  //carreraModificada.setEstado(true);
	    for (int i = 0; i < materias.size(); i++) {
	      Materia materia = materias.get(i);
	      if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
	        materias.set(i, materiaModificada);
	        break;
	      }
	      else {
				System.out.println("No se encuentra el codigo de Carrera");
			}
	    }
	  }
	
	 // Método para eliminar una carrera
	  public static void eliminarMateria(String codigo) {
		  //borrado físico
	    //carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
		  
		  //borrado lógico
		  for (int i = 0; i < materias.size(); i++) {
		      Materia materia = materias.get(i);
		      if (materia.getCodigo().equals(codigo)) {
		        materias.remove(i);;
		        break;
		      }
		    }
	  }	
}
