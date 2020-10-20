package br.com.planets.services.model;

import br.com.planets.drivers.database.Planet;
import br.com.planets.drivers.database.TranslationMovimentEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Rogério Alves
 */
public class PlanetTest {

    @Test
    public void testPlanetIfIsFirstQuadrant() {
        Planet planet = buildPlanet();
        PositionPlanet positionPlanet = PositionPlanet.builder().planet(planet).build();
        positionPlanet.updatePlanetWithNewPositionByDay(30);

        assertEquals(433.01270189221935, planet.getPosition_x());
        assertEquals(249.99999999999997, planet.getPosition_y());
    }

    @Test
    public void testPlanetIfIsSecondQuadrant() {
        Planet planet = buildPlanet();
        PositionPlanet positionPlanet = PositionPlanet.builder().planet(planet).build();
        positionPlanet.updatePlanetWithNewPositionByDay(120);

        assertEquals(-249.9999999999999, planet.getPosition_x());
        assertEquals(433.01270189221935, planet.getPosition_y());
    }

    @Test
    public void testPlanetIfIsThirdQuadrant() {
        Planet planet = buildPlanet();
        PositionPlanet positionPlanet = PositionPlanet.builder().planet(planet).build();
        positionPlanet.updatePlanetWithNewPositionByDay(210);

        assertEquals(-433.0127018922193, planet.getPosition_x());
        assertEquals(-250.00000000000006, planet.getPosition_y());
    }

    @Test
    public void testPlanetIfIsFourthQuadrant() {
        Planet planet = buildPlanet();
        PositionPlanet positionPlanet = PositionPlanet.builder().planet(planet).build();
        positionPlanet.updatePlanetWithNewPositionByDay(300);

        assertEquals(250.00000000000006, planet.getPosition_x());
        assertEquals(-433.0127018922193, planet.getPosition_y());
    }

    @Test
    public void testPlanetDegreesFromXAxis() {
        Planet planet = buildPlanet();
        PositionPlanet positionPlanet = PositionPlanet.builder().planet(planet).build();
        Integer days = 80;
        Integer expected = (days * planet.getVelocity()) % 360;

        assertEquals(expected, positionPlanet.retrieveDegreesFromXAxis(planet, days));
    }

    private Planet buildPlanet() {
        Planet planet = new Planet();
        planet.setName("Ferengi");
        planet.setTranslationMoviment(TranslationMovimentEnum.ANTICLOCKWISE.name());
        planet.setVelocity(1);
        planet.setDistanceFromSun(500);
        planet.setPosition_x(500D);
        planet.setPosition_y(0D);
        return planet;
    }
}
