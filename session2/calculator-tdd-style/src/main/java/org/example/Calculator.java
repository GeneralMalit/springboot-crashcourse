package org.example;

public class Calculator {
    boolean isOn = false;

    public Calculator() {

    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static long add(long a, long b) {
        return a + b;
    }

    public static short add(short a, short b) {
        return (short) (a + b);
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }


    public static int subtract(int a, int b) {
        return a - b;
    }

    public static long subtract(long a, long b) {
        return a - b;
    }

    public static short subtract(short a, short b) {
        return (short) (a - b);
    }

    public static float subtract(float a, float b) {
        return a - b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }


    public static int multiply(int a, int b) {
        return a * b;
    }

    public static long multiply(long a, long b) {
        return a * b;
    }

    public static short multiply(short a, short b) {
        return (short) (a * b);
    }

    public static float multiply(float a, float b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero not allowed");
        }
        return a / b;
    }

    public static long divide(long a, long b) {
        if (b == 0L) {
            throw new IllegalArgumentException("Division by zero not allowed");
        }
        return a / b;
    }

    public static short divide(short a, short b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero not allowed");
        }
        return (short) (a / b);
    }

    public static float divide(float a, float b) {
        if (b == 0.0f) {
            throw new IllegalArgumentException("Division by zero not allowed");
        }
        return a / b;
    }

    public static double divide(double a, double b) {
        if (b == 0.0d) {
            throw new IllegalArgumentException("Division by zero not allowed");
        }
        return a / b;
    }
}
