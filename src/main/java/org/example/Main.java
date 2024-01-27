package org.example;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        double b = 1.5;
        double initialValue = 0.1;
        double endValue = 1.0;
        double step = 0.001;
        printMaxValueOfY(initialValue, endValue, step, b);
        printMinValueOfY(initialValue, endValue, step, b);
    }

    public double calculateY(double b, double x) {
        if (x <= 0.45) {
            return b * x - Math.tan(b * x);
        } else {
            return b * x + Math.log10(b * x);
        }
    }

    public int calculateNumberOfSteps(double initialValue, double endValue, double step) {
        return (int) ((endValue - initialValue) / step) + 1;
    }

    public double[] createYArray(double initialValue, double endValue, double step, double b) {
        int size = calculateNumberOfSteps(initialValue, endValue, step);
        double[] yArray = new double[size];
        double x = initialValue;
        for (int i = 0; i < size; i++) {
            yArray[i] = calculateY(b, x);
            x += step;
        }
        return yArray;
    }

    public double[] createXArray(double initialValue, double endValue, double step) {
        int size = calculateNumberOfSteps(initialValue, endValue, step);
        double[] xArray = new double[size];
        double x = initialValue;
        for (int i = 0; i < size; i++) {
            xArray[i] = x;
            x += step;
        }
        return xArray;
    }

    public int getIndexOfMaxValueOfY(double initialValue, double endValue, double step, double b) {
        double[] yArray = createYArray(initialValue, endValue, step, b);
        double maxY = yArray[0];
        int maxYIndex = 0;
        for (int i = 1; i < yArray.length; i++) {
            if (yArray[i] > maxY) {
                maxY = yArray[i];
                maxYIndex = i;
            }
        }
        return maxYIndex;
    }

    public int getIndexOfMinValueOfY(double initialValue, double endValue, double step, double b) {
        double[] yArray = createYArray(initialValue, endValue, step, b);
        double minY = yArray[0];
        int minYIndex = 0;
        for (int i = 1; i < yArray.length; i++) {
            if (yArray[i] < minY) {
                minY = yArray[i];
                minYIndex = i;
            }
        }
        return minYIndex;
    }

    public double getYValuesSum(double initialValue, double endValue, double step, double b) {
        double[] yArray = createYArray(initialValue, endValue, step, b);
        return Arrays.stream(yArray).sum();
    }

    public double getArithmeticMeanOfYValues(double initialValue, double endValue, double step, double b) {
        return getYValuesSum(initialValue, endValue, step, b) / calculateNumberOfSteps(initialValue, endValue, step);
    }

    public void printMaxValueOfY(double initialValue, double endValue, double step, double b) {
        int indexOfMaxValueOfY = getIndexOfMaxValueOfY(initialValue, endValue, step, b);
        double[] yArray = createYArray(initialValue, endValue, step, b);
        double maxY = yArray[0];
        for (int i = 1; i < yArray.length; i++) {
            if (yArray[i] > maxY) {
                maxY = yArray[i];
            }
        }
        System.out.println("Max Y has index " + indexOfMaxValueOfY + " and value " + maxY);
    }

    public void printMinValueOfY(double initialValue, double endValue, double step, double b) {
        int indexOfMinValueOfY = getIndexOfMinValueOfY(initialValue, endValue, step, b);
        double[] yArray = createYArray(initialValue, endValue, step, b);
        double minY = yArray[0];
        for (int i = 1; i < yArray.length; i++) {
            if (yArray[i] < minY) {
                minY = yArray[i];
            }
        }
        System.out.println("Min Y has index " + indexOfMinValueOfY + " and value " + minY);
    }
}