package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Materia;
@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
    private Materia nuevaMateria; // inyección de dependencias
    
	 @GetMapping("/listado")
	    public String getMateria(Model model) {
	        model.addAttribute("materia", ListadoMateria.listarMaterias());
	        return "listaDeMaterias";
	    }
	 
	 @GetMapping("/nuevo")
	    public ModelAndView getVistaNuevaMateria() {
	        boolean edicion = false; 
	        ModelAndView modelView = new ModelAndView("formMateria");
	        modelView.addObject("nuevaMateria", nuevaMateria);
	        modelView.addObject("edicion", edicion);
	        modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
	        modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
	        return modelView;
	    }
	    
	    @PostMapping("/guardar")
	    public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
	    	//para Guardar
	    	materia.setDocente(ListadoDocentes.buscarDocentePorLegajo(materia.getDocente().getLegajo()));
	    	materia.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materia.getCarrera().getCodigo()));
	    	//mostrar Listado
	        ModelAndView modelView = new ModelAndView("listaDeMaterias");
	        ListadoMateria.agregarMateria(materia);
	        modelView.addObject("materia", ListadoMateria.listarMaterias());
	        return modelView;
	    }
	    
	    
	    @GetMapping("/modificarMateria/{codigo}")
	    public ModelAndView getModificarMateriaPague(@PathVariable(value = "codigo") String codigo) {
	    	ModelAndView modelView = new ModelAndView("formMateria");
	        Materia nuevaMateria = ListadoMateria.buscarMateriaPorCodigo(codigo);
	        boolean edicion = true;
	        modelView.addObject("nuevaMateria", nuevaMateria);
	        modelView.addObject("edicion", edicion);
	        modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
	        modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
	        return modelView;
	    }
	    
	    @PostMapping("/modificar")
	    public String modificarMateria(@ModelAttribute("nuevaMateria") Materia materia) {
	    	
	    	//para Guardar
	    	materia.setDocente(ListadoDocentes.buscarDocentePorLegajo(materia.getDocente().getLegajo()));
	    	materia.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materia.getCarrera().getCodigo()));
	    	//System.out.println(.getCodigo());
	        ListadoMateria.modificarMateria(materia);
	        return "redirect:/materia/listado";
	    }
	    
	    @GetMapping("/borrarMateria/{codigo}")
	    public String eliminarMateria(@PathVariable(value = "codigo") String codigo) {
	    	ListadoMateria.eliminarMateria(codigo);
	    	return "redirect:/materia/listado";
	    }
	   
}
