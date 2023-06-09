package edu.dallascollege.assignment15.runners;
import edu.dallascollege.assignment15.repos.AstroRepository;
import edu.dallascollege.assignment15.services.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
public class LoadAstroRunner implements CommandLineRunner {
    @Autowired
    AstroRepository repo;	// Spring provides a repo class reference here during initializing

    //@Override
    public void run(String... args) { 	// Abstract method CommandLineRunner requires
        AstroService load = new AstroService((RestTemplateBuilder) repo);
        load.getAstronauts();
    }
}
