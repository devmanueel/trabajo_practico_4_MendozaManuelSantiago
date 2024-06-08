package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")

public class DocenteController {
	
	@Autowired
	private Docente nuevoDocente;
	
    // Muestra Carreras
    @GetMapping("/listadoDocente")
    public String getCarreras(Model model) {
        model.addAttribute("docente",ListadoDocentes.listarDocentes());
        
        return "listadoDeDocentes";
    }
    @GetMapping("/nuevo")
    public String getVistaNuevaDocente(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        model.addAttribute("nuevoDocente", nuevoDocente);
        model.addAttribute("edicion", edicion);
        return "formDocente";
    }
    
    @PostMapping("/guardar")
    public String guardarDocente(@ModelAttribute("docente") Docente docente) {
        //ModelAndView modelView = new ModelAndView("listadoDeDocentes");
        ListadoDocentes.agregarDocente(docente);
        //docente.ListadoDocentes.listarDocentes());
        
        return "redirect:/docente/listadoDocente";
    }
	
    @GetMapping("/modificar/{legajo}")
    public String getModificarDocentePague(Model model, @PathVariable(value = "legajo") String legajo) {
        Docente nuevoDocente = ListadoDocentes.buscarDocentePorLegajo(legajo);
        boolean edicion = true;
        model.addAttribute("nuevoDocente", nuevoDocente);
        model.addAttribute("edicion", edicion);
        return "formDocente";
    }
    
    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("nuevoDocente") Docente docente) {
    	//System.out.println(carrera.getCodigo());
        ListadoDocentes.modificarDocente(docente);
        return "redirect:/docente/listadoDocente";
    }
    
    @GetMapping("/borrar/{legajo}")
    public String eliminarDocente(@PathVariable(value = "legajo") String legajo) {
    	ListadoDocentes.eliminarDocente(legajo);
    	return "redirect:/docente/listadoDocente";
    }
}
