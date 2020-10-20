package br.com.planets.usecases;

import br.com.planets.controller.CalculateWeatherResponse;
import br.com.planets.drivers.database.Weather;
import br.com.planets.drivers.database.WeatherTypeEnum;
import br.com.planets.services.WeatherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Rogério Alves
 */
@Service
public class CalculateWeatherServiceImpl implements CalculateWeatherService {

    private final WeatherService weatherService;

    public CalculateWeatherServiceImpl(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public CalculateWeatherResponse retrieveWeatherFromDay(final Integer day) {
        Optional<Weather> weather = weatherService.retrieveWeatherFromDay(day);
        return buildCalculateWeatherResponse(weather);
    }

    private CalculateWeatherResponse buildCalculateWeatherResponse(final Optional<Weather> weather) {
        if (weather.isPresent()) {
            return CalculateWeatherResponse.builder()
                    .dia(weather.get().getDay())
                    .clima(WeatherTypeEnum.valueOf(weather.get().getWeather()).getWeatherType())
                    .build();
        } else {
            return CalculateWeatherResponse.builder().build();
        }
    }
}
