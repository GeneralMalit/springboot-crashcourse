package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void shouldBeTurnedOff(){
        Calculator calculator = new Calculator();
        assertFalse(calculator.isOn());
    }

    @Test
    void shouldBeTurnedOn(){
        Calculator calculator = new Calculator();
        calculator.setOn(true);
        assertTrue(calculator.isOn());
    }

    @Test
    void shouldBeOffWhenTurnedOff(){
        Calculator calculator = new Calculator();
        calculator.setOn(false);
        assertFalse(calculator.isOn());
    }


    @Test
    void testCalculatorState() {
        Calculator calculator = new Calculator();
        assertFalse(calculator.isOn());

        calculator.setOn(true);
        assertTrue(calculator.isOn());

        calculator.setOn(false);
        assertFalse(calculator.isOn());
    }

    @Test
    void testAdd() {
        assertEquals(5, Calculator.add(2, 3));
        assertEquals(5L, Calculator.add(2L, 3L));
        assertEquals((short) 5, Calculator.add((short) 2, (short) 3));
        assertEquals(5.0f, Calculator.add(2.0f, 3.0f), 0.0001f);
        assertEquals(5.0, Calculator.add(2.0, 3.0), 0.0001);
    }

    @Test
    void testSubtract() {
        assertEquals(1, Calculator.subtract(3, 2));
        assertEquals(1L, Calculator.subtract(3L, 2L));
        assertEquals((short) 1, Calculator.subtract((short) 3, (short) 2));
        assertEquals(1.0f, Calculator.subtract(3.0f, 2.0f), 0.0001f);
        assertEquals(1.0, Calculator.subtract(3.0, 2.0), 0.0001);
    }

    @Test
    void testMultiply() {
        assertEquals(6, Calculator.multiply(2, 3));
        assertEquals(6L, Calculator.multiply(2L, 3L));
        assertEquals((short) 6, Calculator.multiply((short) 2, (short) 3));
        assertEquals(6.0f, Calculator.multiply(2.0f, 3.0f), 0.0001f);
        assertEquals(6.0, Calculator.multiply(2.0, 3.0), 0.0001);
    }

    @Test
    void testDivide() {
        assertEquals(2, Calculator.divide(6, 3));
        assertEquals(2L, Calculator.divide(6L, 3L));
        assertEquals((short) 2, Calculator.divide((short) 6, (short) 3));
        assertEquals(2.0f, Calculator.divide(6.0f, 3.0f), 0.0001f);
        assertEquals(2.0, Calculator.divide(6.0, 3.0), 0.0001);
    }

    @Test
    void testDivideByZeroInt() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.divide(10, 0));
    }

    @Test
    void testDivideByZeroLong() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.divide(10L, 0L));
    }

    @Test
    void testDivideByZeroShort() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.divide((short) 10, (short) 0));
    }

    @Test
    void testDivideByZeroFloat() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.divide(10.0f, 0.0f));
    }

    @Test
    void testDivideByZeroDouble() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.divide(10.0, 0.0));
    }

}