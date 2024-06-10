package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> docentes = new ArrayList<Docente>();
	
	
		//metodo para listar todas las carreras
		public static List<Docente> listarDocentes(){
			if(docentes.isEmpty()) {
				docentes.add(new Docente("n1", "Juan Carlos", "Rodriguez", "JuanCarlos@gmail.com", 388982233,"JCR.png"));
				docentes.add(new Docente("n2", "Gustavo", "Sosa", "GustavoSosa@gmail.com", 388982233,"sosa.jpg"));
				docentes.add(new Docente("n3", "Ariel", "Vega", "ArielVega@gmail.com", 388982233,"vega.png"));
				
			}
			 return docentes;
		}
		
		// Método para buscar un Docente por Legajo
		  public static Docente buscarDocentePorLegajo(String leg) {
		    for (Docente d : docentes) {
		      if (d.getLegajo().equals(leg)) {
		        return d;
		      }
		    }
		    return null;
		  }
		  

		  // Método para agregar un DOCENTE
		  public static void agregarDocente(Docente d) {
		    docentes.add(d);
		  }
		  
		  
		// Método para modificar un Docente
		  public static void modificarDocente(Docente docenteModificado) {
		    for (int i = 0; i < docentes.size(); i++) {
		      Docente docente = docentes.get(i);
		      if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
		        docentes.set(i, docenteModificado);
		        break;
		      }
		    }
		  }

		  // Método para eliminar un DOCENTE
		  public static void eliminarDocente(String leg) {
		    docentes.removeIf(docente -> docente.getLegajo().equals(leg));
		  }
		  
		  
		
}
