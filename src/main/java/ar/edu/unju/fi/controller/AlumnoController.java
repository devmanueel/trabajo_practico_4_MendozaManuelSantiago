package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.ListadoAlumnos;

import ar.edu.unju.fi.model.Alumno;



@Controller
@RequestMapping("/alumno")

public class AlumnoController {
	
	@Autowired
	private Alumno nuevoAlumno;
	
    // Muestra Alumnos
    @GetMapping("/listadoAlumno")
    public String getAlumno(Model model) {
        model.addAttribute("alumno",ListadoAlumnos.listarAlumnos());
        return "listaDeAlumnos";
    }
    
    @GetMapping("/nuevo")
    public String getVistaNuevoAlumno(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        model.addAttribute("nuevoAlumno", nuevoAlumno);
        model.addAttribute("edicion", edicion);
        return "formAlumno";
    }
    
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        //ModelAndView modelView = new ModelAndView("listadoDeDocentes");
        ListadoAlumnos.agregarAlumno(alumno);
        //docente.ListadoDocentes.listarDocentes());
        
        return "redirect:/alumno/listadoAlumno";
    }
    
    @GetMapping("/modificar/{LU}")
    public String getModificarAlumnoPague(Model model, @PathVariable(value = "LU") String LU) {
        Alumno nuevoAlumno = ListadoAlumnos.buscarAlumnoPorLu(LU);
        boolean edicion = true;
        model.addAttribute("nuevoAlumno", nuevoAlumno);
        model.addAttribute("edicion", edicion);
        return "formAlumno";
    }
    
    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("nuevoAlumno") Alumno alumno) {
    	//System.out.println(carrera.getCodigo());
        ListadoAlumnos.modificarAlumno(alumno);
        return "redirect:/alumno/listadoAlumno";
    }
    
    @GetMapping("/borrar/{LU}")
    public String eliminarAlumno(@PathVariable(value = "LU") String LU) {
    	ListadoAlumnos.eliminarAlumno(LU);
    	return "redirect:/alumno/listadoAlumno";
    }
}
