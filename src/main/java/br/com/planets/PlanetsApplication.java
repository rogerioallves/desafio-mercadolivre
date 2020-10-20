package br.com.planets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PlanetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanetsApplication.class, args);
    }
}
