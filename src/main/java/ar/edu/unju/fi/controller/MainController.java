package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/principal")

public class MainController {
	
	@GetMapping({"/index","/home"})
	
	public String getIndex() {
		return "index";
	}
	
	
}
