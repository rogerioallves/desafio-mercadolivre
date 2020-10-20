package br.com.planets.services;

import br.com.planets.drivers.database.Planet;

import java.util.List;
import java.util.Optional;

/**
 * @author Rogério Alves
 */
public interface PlanetService {

    void calculateWeatherPlanetsByDay(Integer day);

    Optional<List<Planet>> findAllPlanets();
}
