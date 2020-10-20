package br.com.planets.services.model;

import br.com.planets.drivers.database.Planet;
import br.com.planets.drivers.database.TranslationMovimentEnum;
import lombok.Builder;

/**
 * @author Rogério Alves
 */
@Builder
public class PositionPlanet {
    private static Integer ORBIT_DEGREES = 360;

    private Planet planet;

    public void updatePlanetWithNewPositionByDay(final Integer day) {
        Integer degrees = retrieveDegreesFromXAxis(planet, day);
        double radians = Math.toRadians(degrees);

        double newPositionX = planet.getDistanceFromSun() * Math.cos(radians);
        double newPositionY = planet.getDistanceFromSun() * Math.sin(radians);

        planet.setPosition_x(newPositionX);
        planet.setPosition_y(newPositionY);
    }

    public Integer retrieveDegreesFromXAxis(final Planet planet, final Integer day) {
        Integer currentDegrees = (planet.getVelocity() * day) % ORBIT_DEGREES;

        if (TranslationMovimentEnum.CLOCKWISE.name().equals(planet.getTranslationMoviment()) && currentDegrees != 0) {
            currentDegrees = ORBIT_DEGREES - currentDegrees;
        }

        return currentDegrees;
    }
}
