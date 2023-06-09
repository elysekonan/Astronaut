package edu.dallascollege.assignment15.controllers;

import edu.dallascollege.assignment15.entities.AstroResponse;
import edu.dallascollege.assignment15.services.AstroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AstroRestController {
    final AstroService service;

    public AstroRestController(AstroService service) {
        this.service = service;

    }

    @GetMapping("/astronauts")
    public String getAstronauts( ) {
        ResponseEntity<AstroResponse> response = service.getAstronauts();
        if ( response.getStatusCode().equals(HttpStatus.OK) ) {
            AstroResponse astronauts = response.getBody();
            assert astronauts != null;
            return astronauts.people().toString();        }
        return HttpStatus.NOT_FOUND.toString();
    }

}
