package br.com.planets.drivers.jobs;

import br.com.planets.services.WeatherService;
import br.com.planets.services.PlanetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author Rogério Alves
 */
@EnableAsync
@Component
public class CalculateWeatherScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(CalculateWeatherScheduledTask.class);
    private static final int DAYS_PREDICTION = 365 * 10;

    private final PlanetService planetService;
    private final WeatherService weatherService;

    public CalculateWeatherScheduledTask(final PlanetService planetService, final WeatherService weatherService) {
        this.planetService = planetService;
        this.weatherService = weatherService;
    }

    @Async
    @EventListener(ApplicationReadyEvent.class)
    public void calculateWeatherFirstTime() {
        log.info("Calculate Weather.");
        for (int i = 0; i <= DAYS_PREDICTION; i++) {
            planetService.calculateWeatherPlanetsByDay(i);
            weatherService.saveWeatherByDay(i);
        }
    }
}
