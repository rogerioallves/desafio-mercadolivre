package br.com.planets.services.model;

import lombok.Builder;

/**
 * @author Rogério Alves
 */
@Builder
public class Triangle {
    private static double PRECISION = 0.01;

    private Coordinate coordinateA;
    private Coordinate coordinateB;
    private Coordinate coordinateC;

    public boolean verifyCoordinateIsTriangle(final Coordinate coordinate) {
        Double triangleArea = calculateAreaTriangle(coordinateA, coordinateB, coordinateC);

        double triangleAreaA = calculateAreaTriangle(coordinate, coordinateB, coordinateC);
        double triangleAreaB = calculateAreaTriangle(coordinateA, coordinate, coordinateC);
        double triangleAreaC = calculateAreaTriangle(coordinateA, coordinateB, coordinate                                                                                                                                                           );

        return triangleArea.equals(triangleAreaA + triangleAreaB + triangleAreaC);
    }

    private double calculateAreaTriangle(final Coordinate pointA, final Coordinate pointB, final Coordinate pointC) {
        double valuePointA = pointA.getX() * (pointB.getY() - pointC.getY());
        double valuePointB = pointB.getX() * (pointC.getY() - pointA.getY());
        double valuePointC = pointC.getX() * (pointA.getY() - pointB.getY());

        return Math.abs((valuePointA + valuePointB + valuePointC) / 2);
    }
}
