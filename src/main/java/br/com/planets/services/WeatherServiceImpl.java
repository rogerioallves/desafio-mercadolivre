package br.com.planets.services;

import br.com.planets.drivers.database.Weather;
import br.com.planets.drivers.database.WeatherRepository;
import br.com.planets.drivers.database.WeatherTypeEnum;
import br.com.planets.drivers.database.Planet;
import br.com.planets.services.model.Coordinate;
import br.com.planets.services.model.Line;
import br.com.planets.services.model.Triangle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Rogério Alves
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String PLANET_FERENGI = "Ferengi";
    private static final String PLANET_BETASOIDE = "Betasoide";
    private static final String PLANET_VULCANO = "Vulcano";

    private final WeatherRepository weatherRepository;
    private final PlanetService planetService;

    public WeatherServiceImpl(final WeatherRepository weatherRepository, final PlanetService planetService) {
        this.weatherRepository = weatherRepository;
        this.planetService = planetService;
    }

    @Override
    public Optional<Weather> retrieveWeatherFromDay(final Integer dia) {
        return weatherRepository.findWeatherByDay(dia);
    }

    @Override
    public void saveWeatherByDay(final Integer day) {
        Optional<List<Planet>> planetsOpt = planetService.findAllPlanets();

        if (planetsOpt.isPresent()) {
            String weatherFromPlanet = retrieveWeatherFromPlanets(planetsOpt.get());
            Weather weather = new Weather();
            weather.setWeather(weatherFromPlanet);
            weather.setDay(day);
            weatherRepository.save(weather);
        }
    }

    private String retrieveWeatherFromPlanets(final List<Planet> planets) {
        Coordinate sunCoordinate = Coordinate.builder().x(0.0).y(0.0).build();
        Coordinate coordinatePlanetFerengi = retriveCoordinateFromPlanetName(PLANET_FERENGI, planets);
        Coordinate coordinatePlanetBetasoide = retriveCoordinateFromPlanetName(PLANET_BETASOIDE, planets);
        Coordinate coordinatePlanetVulcano = retriveCoordinateFromPlanetName(PLANET_VULCANO, planets);

        Line sunLine = Line.builder().coordinateA(sunCoordinate)
                .coordinateB(coordinatePlanetFerengi).build();
        if (sunLine.verifyCoordinateIsLine(coordinatePlanetVulcano) &&
                sunLine.verifyCoordinateIsLine(coordinatePlanetBetasoide)) {
            return WeatherTypeEnum.DROUGHT.name();
        }

        Line lineIntoPlanets = Line.builder()
                .coordinateA(coordinatePlanetFerengi)
                .coordinateB(coordinatePlanetBetasoide).build();
        if (lineIntoPlanets.verifyCoordinateIsLine(coordinatePlanetVulcano)) {
            return WeatherTypeEnum.OPTIMAL_PRESSURE.name();
        }

        Triangle planetsTriangle = Triangle.builder().coordinateA(coordinatePlanetFerengi)
                .coordinateB(coordinatePlanetBetasoide).coordinateC(coordinatePlanetVulcano).build();
        if (planetsTriangle.verifyCoordinateIsTriangle(sunCoordinate)) {
            return WeatherTypeEnum.RAIN.name();
        }

        return WeatherTypeEnum.UNKNONW.name();
    }

    private Coordinate retriveCoordinateFromPlanetName(final String planetName, final List<Planet> planets) {
        Planet planet = retrievePlanetByName(planetName, planets);

        if (planet == null) {
            return null;
        }

        return Coordinate.buildCoordinateFromPlanet(planet);
    }

    private Planet retrievePlanetByName(final String planetName, final List<Planet> planets) {
        Optional<Planet> planet = planets.stream().filter(p -> {
            return p.getName().equalsIgnoreCase(planetName);
        }).findFirst();

        return planet.isPresent() ? planet.get() : null;
    }


}
