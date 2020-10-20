package br.com.planets.services.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Rogério Alves
 */
public class LineTest {

    @Test
    public void testCoordinateIsLineReturnsTrue() {
        Coordinate coordinateA = new Coordinate(0, -1);
        Coordinate coordinateB = new Coordinate(4, 1);
        Line line = Line.builder().coordinateA(coordinateA).coordinateB(coordinateB).build();

        Coordinate coordinateLine = new Coordinate(2, 0);
        assertTrue(line.verifyCoordinateIsLine(coordinateLine), "Coordinate is a line");
    }

    @Test
    public void testCoordinateIsLineReturnsFalse() {
        Coordinate coordinateA = new Coordinate(0, -1);
        Coordinate coordinateB = new Coordinate(4, 1);
        Line line = Line.builder().coordinateA(coordinateA).coordinateB(coordinateB).build();

        Coordinate coordinateLine = new Coordinate(1, 1);
        assertFalse(line.verifyCoordinateIsLine(coordinateLine), "Coordinate isn't a line");
    }
}
