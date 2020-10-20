package br.com.planets.services.model;

import lombok.Builder;

/**
 * @author Rogério Alves
 */
@Builder
public class Line {
    private static double PRECISION = 0.01;

    private Coordinate coordinateA;
    private Coordinate coordinateB;

    public boolean verifyCoordinateIsLine(final Coordinate coordinate) {
        Double slope = retrieveSlopeFromCoordinate();

        if (slope == null) {
            return Math.abs(coordinateA.getX() - coordinate.getX()) < PRECISION;
        }

        double calculatedY = slope * coordinate.getX() + calculateYAxisIntersection(slope);
        return Math.abs(calculatedY - coordinate.getY()) < PRECISION;
    }

    private Double retrieveSlopeFromCoordinate() {
        double deltaX = coordinateB.getX() - coordinateA.getX();

        if (deltaX == 0d) {
            return null;
        }

        double deltaY = coordinateB.getY() - coordinateA.getY();
        return deltaY / deltaX;
    }

    private Double calculateYAxisIntersection(final Double slope) {
        return this.coordinateA.getY() - slope * this.coordinateA.getX();
    }
}
