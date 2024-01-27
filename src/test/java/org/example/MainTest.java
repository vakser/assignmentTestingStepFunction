package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testCalculateY1() {
        double b = 1.5;
        double x = 0.1;
        double expected = 0.15 - Math.tan(0.15);
        double actual = main.calculateY(b, x);
        assertEquals(expected, actual, 0.000001);
    }

    @Test
    public void testCalculateY2() {
        double b = 1.5;
        double x = 0.5;
        double expected = 0.75 + Math.log10(0.75);
        double actual = main.calculateY(b, x);
        assertEquals(expected, actual, 0.000001);
    }

    @ParameterizedTest
    @CsvSource({
            "1.5, 0.1, -0.0011352180582950844",
            "1.5, 0.3, -0.03305506561657834",
            "1.5, 1.0, 1.6760912590556813"
    })
    public void testCalculateYParameterized(double b, double x, double expected) {
        assertEquals(expected, main.calculateY(b, x), 0.000001);
    }

    @Test
    public void testCalculateNumberOfSteps() {
        double initialValue = 0.1;
        double endValue = 1.0;
        double step = 0.001;
        int expected = 901;
        int actual = main.calculateNumberOfSteps(initialValue, endValue, step);
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateYArray() {
        double[] yArray = main.createYArray(0.1, 1.0, 0.001, 1.5);
        double y1 = yArray[0];
        double y2 = yArray[200];
        double y3 = yArray[900];
        assertEquals(-0.0011352180582950844, y1, 0.000001);
        assertEquals(-0.03305506561657834, y2, 0.000001);
        assertEquals(1.6760912590556813, y3, 0.000001);
    }

    @Test
    public void testCreateXArray() {
        double[] xArray = main.createXArray(0.1, 1.0, 0.001);
        double x1 = xArray[0];
        double x2 = xArray[200];
        double x3 = xArray[900];
        assertEquals(0.1, x1, 0.000001);
        assertEquals(0.3, x2, 0.000001);
        assertEquals(1.0, x3, 0.000001);
    }

    @Test
    public void testGetIndexOfMaxValueOfY() {
        int indexOfMaxValueOfY = main.getIndexOfMaxValueOfY(0.1, 1.0, 0.001, 1.5);
        int expected = 900;
        assertEquals(expected, indexOfMaxValueOfY);
    }

    @Test
    public void testGetIndexOfMinValueOfY() {
        int indexOfMinValueOfY = main.getIndexOfMinValueOfY(0.1, 1.0, 0.001, 1.5);
        int expected = 349;
        assertEquals(expected, indexOfMinValueOfY);
    }

    @Test
    public void testGetYValuesSum() {
        double yValuesSum = main.getYValuesSum(0.1, 1.0, 0.001, 1.5);
        double expected = 600.1861639424061;
        assertEquals(expected, yValuesSum, 0.000001);
    }

    @Test
    public void testGetArithmeticMeanOfYValues() {
        double arithmeticMeanOfYValues = main.getArithmeticMeanOfYValues(0.1, 1.0, 0.001, 1.5);
        double expected = 0.6661333673056672;
        assertEquals(expected, arithmeticMeanOfYValues, 0.000001);
    }

}