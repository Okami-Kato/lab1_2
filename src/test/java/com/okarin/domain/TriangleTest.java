package com.okarin.domain;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

class TriangleTest {

    private final Triangle firstTriangle = new Triangle(5, 5, 7);

    private final Triangle secondTriangle = new Triangle(5, 7, 5);

    private final Triangle thirdTriangle = new Triangle(7, 5, 5);

    @Test
    void getArea() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(5, 5, 5));
    }

    @Test
    void getPerimeter() {

    }

    @Test
    void getType() {

    }
}