package br.com.planets.services.model;

import br.com.planets.drivers.database.Planet;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Rogério Alves
 */
@Getter
@Builder
public class Coordinate {
    private double x;
    private double y;

    public static Coordinate buildCoordinateFromPlanet(final Planet planet) {
        return Coordinate.builder()
                         .x(planet.getPosition_x())
                         .y(planet.getPosition_y())
                         .build();
    }
}
