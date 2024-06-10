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
import ar.edu.unju.fi.model.Carrera;



@Controller
@RequestMapping("/carrera")
public class CarreraController {
    
    @Autowired
    private Carrera nuevaCarrera; // inyección de dependencias
    
    // Muestra Carreras
    @GetMapping("/listado")
    public String getCarreras(Model model) {
        model.addAttribute("carrera", ListadoCarreras.listarCarreras());
        return "listaDeCarreras";
    }
    
    @GetMapping("/nuevo")
    public String getVistaNuevaCarrera(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        model.addAttribute("nuevaCarrera", nuevaCarrera);
        model.addAttribute("edicion", edicion);
        return "formCarrera";
    }
    
    @PostMapping("/guardar")
    public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
        ModelAndView modelView = new ModelAndView("listaDeCarreras");
        carrera.setEstado(true);
        ListadoCarreras.agregarCarrera(carrera);
        modelView.addObject("carrera", ListadoCarreras.listarCarreras());
        return modelView;
    }
    
    @GetMapping("/modificarCarrera/{codigo}")
    public String getModificarCarreraPague(Model model, @PathVariable(value = "codigo") String codigo) {
        Carrera nuevaCarrera = ListadoCarreras.buscarCarreraPorCodigo(codigo);
        boolean edicion = true;
        model.addAttribute("nuevaCarrera", nuevaCarrera);
        model.addAttribute("edicion", edicion);
        return "formCarrera";
    }
    
    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carrera) {
    	System.out.println(carrera.getCodigo());
        ListadoCarreras.modificarCarrera(carrera);
        return "redirect:/carrera/listado";
    }
    
    @GetMapping("/borrarCarrera/{codigo}")
    public String eliminarCarrera(@PathVariable(value = "codigo") String codigo) {
    	ListadoCarreras.eliminarCarrera(codigo);
    	return "redirect:/carrera/listado";
    }
   
    
}
