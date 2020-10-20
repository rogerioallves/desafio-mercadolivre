package br.com.planets.services;

import br.com.planets.drivers.database.Weather;

import java.util.Optional;

/**
 * @author Rogério Alves
 */
public interface WeatherService {

    Optional<Weather> retrieveWeatherFromDay(Integer day);

    void saveWeatherByDay(Integer day);
}
