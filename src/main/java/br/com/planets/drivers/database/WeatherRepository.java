package br.com.planets.drivers.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Rogério Alves
 */
@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findWeatherByDay(Integer day);
}
