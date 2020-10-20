package br.com.planets.controller;

import br.com.planets.usecases.CalculateWeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rogério Alves
 */
@RestController
public class CalculateWeatherController {

    private final CalculateWeatherService calculateWeatherService;

    public CalculateWeatherController(final CalculateWeatherService calculateWeatherService) {
        this.calculateWeatherService = calculateWeatherService;
    }

    @GetMapping("/clima/{dia}")
    CalculateWeatherResponse calculateClima(@PathVariable final int dia) {
        return calculateWeatherService.retrieveWeatherFromDay(dia);
    }
}
