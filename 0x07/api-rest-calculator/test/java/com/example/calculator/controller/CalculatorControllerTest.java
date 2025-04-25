package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem-vindo à Calculadora!", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers?number1=2.0&number2=3.0");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Resultado da soma: 5.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        RequestBuilder request = get("/calculator/subNumbers?number1=5.0&number2=3.0");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Resultado da subtração: 2.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers?number1=6.0&number2=2.0");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Resultado da divisão: 3.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbersByZero() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers?number1=6.0&number2=0.0");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Divisão por zero não é permitido.", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        RequestBuilder request = get("/calculator/factorial?factorial=5");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Resultado do fatorial: 120", result.getResponse().getContentAsString());
    }

    @Test
    void factorialNegative() throws Exception {
        RequestBuilder request = get("/calculator/factorial?factorial=-1");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Fatorial de número negativo não é permitido.", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        RequestBuilder request = get("/calculator/calculeDayBetweenDate?localDate1=2023-10-26&localDate2=2023-10-31");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Diferença em dias: 5", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        RequestBuilder request = get("/calculator/integerToBinary?number1=10");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Resultado em binário: 1010", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        RequestBuilder request = get("/calculator/integerToHexadecimal?number1=255");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("Resultado em hexadecimal: FF", result.getResponse().getContentAsString());
    }
}
