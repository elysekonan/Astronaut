package edu.dallascollege.assignment15.services;

import edu.dallascollege.assignment15.entities.AstroResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class AstroServiceTest {
    private final Logger logger =
            LoggerFactory.getLogger(AstroServiceTest.class);

    @Autowired
    private AstroService service;

    @Test
    public void getAstronauts() {
        ResponseEntity<AstroResponse> response = service.getAstronauts();
        logger.info(response.toString());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        AstroResponse people = response.getBody();
        assertNotNull(people);
        assertTrue(people.number() >= 0);
        assertEquals(people.number(), people.people().size());
        System.out.println(people.people().size() + " astronauts in space.");
        people.people().forEach(System.out::println);
    }
}
