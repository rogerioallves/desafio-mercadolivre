package br.com.planets.usecases;

import br.com.planets.controller.CalculateWeatherResponse;

/**
 * @author Rogério Alves
 */
public interface CalculateWeatherService {

    CalculateWeatherResponse retrieveWeatherFromDay(Integer day);
}
