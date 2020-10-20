package br.com.planets.services.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Rogério Alves
 */
public class TriangleTest {

    @Test
    public void testCoordinateIsTriangleReturnsTrue() {
        Coordinate coordinateA = new Coordinate(-3, -3);
        Coordinate coordinateB = new Coordinate(3, 3);
        Coordinate coordinateC = new Coordinate(0, -3);
        Triangle triangle = Triangle.builder().coordinateA(coordinateA)
                .coordinateB(coordinateB).coordinateC(coordinateC).build();

        Coordinate coordinateLine = new Coordinate(0, 0);
        assertTrue(triangle.verifyCoordinateIsTriangle(coordinateLine), "Coordinate is a triangle");
    }

    @Test
    public void testCoordinateIsTriangleReturnsFalse() {
        Coordinate coordinateA = new Coordinate(0, -1);
        Coordinate coordinateB = new Coordinate(4, 1);
        Coordinate coordinateC = new Coordinate(4, 1);
        Triangle triangle = Triangle.builder().coordinateA(coordinateA)
                .coordinateB(coordinateB).coordinateC(coordinateC).build();

        Coordinate coordinateLine = new Coordinate(0, 0);
        assertFalse(triangle.verifyCoordinateIsTriangle(coordinateLine), "Coordinate isn't a triangle");
    }
}
