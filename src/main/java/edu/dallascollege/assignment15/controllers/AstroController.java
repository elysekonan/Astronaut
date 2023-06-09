package edu.dallascollege.assignment15.controllers;

import edu.dallascollege.assignment15.entities.AstroResponse;
import edu.dallascollege.assignment15.services.AstroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AstroController {
    final AstroService service;

    public AstroController(AstroService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String getAstronauts( Model model) {
        ResponseEntity<AstroResponse> response = service.getAstronauts();
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            AstroResponse astronauts = response.getBody();
            assert astronauts != null;
            model.addAttribute("count", astronauts.number());
            model.addAttribute("list", astronauts.people());
            return "out.html";
        }
        return HttpStatus.NOT_FOUND.toString();
    }
}
