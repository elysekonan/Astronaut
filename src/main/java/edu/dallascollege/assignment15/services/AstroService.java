package edu.dallascollege.assignment15.services;
import edu.dallascollege.assignment15.entities.AstroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class AstroService {
    private final RestTemplate template;

    @Autowired
    public AstroService(RestTemplateBuilder builder) {
        template = builder.setConnectTimeout(Duration.ofSeconds(3)).build();
    }

    public ResponseEntity<AstroResponse> getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";
        return template.getForEntity(url, AstroResponse.class);
    }
}
