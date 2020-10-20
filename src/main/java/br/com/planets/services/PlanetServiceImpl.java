package br.com.planets.services;

import br.com.planets.drivers.database.Planet;
import br.com.planets.drivers.database.PlanetRepository;
import br.com.planets.services.model.PositionPlanet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Rogério Alves
 */
@Service
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetServiceImpl(final PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void calculateWeatherPlanetsByDay(final Integer day) {
        Optional<List<Planet>> planetList = findAllPlanets();

        if (planetList.isPresent()) {
            List<Planet> planets = planetList.get();
            PositionPlanet positionPlanet;

            for (Planet planet : planets) {
                positionPlanet = PositionPlanet.builder().planet(planet).build();
                positionPlanet.updatePlanetWithNewPositionByDay(day);
            }

            planetRepository.saveAll(planets);
        }
    }

    public Optional<List<Planet>> findAllPlanets() {
        return Optional.ofNullable(planetRepository.findAll());
    }
}
