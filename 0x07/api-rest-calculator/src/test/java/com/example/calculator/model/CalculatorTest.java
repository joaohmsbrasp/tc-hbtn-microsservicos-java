package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        assertEquals(5.0, calculator.sum(2.0, 3.0));
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 3.0));
        assertThrows(NullPointerException.class, () -> calculator.sum(2.0, null));
        assertThrows(NullPointerException.class, () -> calculator.sum(null, null));
    }

    @Test
    void subTest() {
        assertEquals(-1.0, calculator.sub(2.0, 3.0));
    }

    @Test
    void divideTest() {
        assertEquals(2.0, calculator.divide(6.0, 3.0));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(6.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
        assertThrows(NullPointerException.class, () -> calculator.factorial(null));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals("101", calculator.integerToBinary(5));
        assertEquals("1", calculator.integerToBinary(1));
        assertEquals("0", calculator.integerToBinary(0));
        assertThrows(NullPointerException.class, () -> calculator.integerToBinary(null));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("5", calculator.integerToHexadecimal(5));
        assertEquals("1", calculator.integerToHexadecimal(1));
        assertEquals("0", calculator.integerToHexadecimal(0));
        assertEquals("AA", calculator.integerToHexadecimal(170));
        assertThrows(NullPointerException.class, () -> calculator.integerToHexadecimal(null));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calculator.calculeDayBetweenDate(date1, date2));
        assertThrows(NullPointerException.class, () -> calculator.calculeDayBetweenDate(null, date2));
        assertThrows(NullPointerException.class, () -> calculator.calculeDayBetweenDate(date1, null));
        assertThrows(NullPointerException.class, () -> calculator.calculeDayBetweenDate(null, null));
    }
}