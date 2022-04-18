package com.okarin.domain;

import lombok.Getter;

@Getter
public class Triangle {

    private final double firstSide;

    private final double secondSide;

    private final double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        if (firstSide <= 0 || secondSide <= 0 || thirdSide <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive");
        }
        if (firstSide + secondSide <= thirdSide ||
                firstSide + thirdSide <= secondSide ||
                secondSide + thirdSide <= firstSide) {
            throw new IllegalArgumentException("Triangle with sides [%f, %f, %f] doesn't exist".formatted(firstSide, secondSide, thirdSide));
        }
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }

    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    public TriangleType getType() {
        if (firstSide == secondSide && secondSide == thirdSide) {
            return TriangleType.EQUILATERAL;
        }
        if (firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.VERSATILE;
    }

    private enum TriangleType {
        ISOSCELES,
        EQUILATERAL,
        VERSATILE
    }
}
