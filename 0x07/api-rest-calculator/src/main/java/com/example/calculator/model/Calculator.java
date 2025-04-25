package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 - number2;
    }

    public Double divide(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        if (number2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer number) {
        if (number == null) {
            throw new NullPointerException("Número é obrigatório.");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Fatorial de número negativo não é permitido.");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public String integerToBinary(Integer number) {
        if (number == null) {
            throw new NullPointerException("Número é obrigatório.");
        }
        return Integer.toBinaryString(number);
    }

    public String integerToHexadecimal(Integer number) {
        if (number == null) {
            throw new NullPointerException("Número é obrigatório.");
        }
        return Integer.toHexString(number).toUpperCase();
    }

    public long calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new NullPointerException("As datas são obrigatórias.");
        }
        return ChronoUnit.DAYS.between(date1, date2);
    }
}