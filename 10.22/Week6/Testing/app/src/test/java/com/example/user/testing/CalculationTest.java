package com.example.user.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CalculationTest {

    private int valueA;
    private int valueB;
    private int expectedValue;
    private Calculation calculation;
    private int fakeMultiple;
    private int expectedMultiple;

    @Mock
    Multiplication multiplication;

    @Before
    public void setUp() throws Exception {
        System.out.println("CalculationTest.setUp");

        MockitoAnnotations.initMocks(this);
        valueA = 10;
        valueB = 20;
        expectedValue = 30;
        fakeMultiple = 10;
        expectedMultiple = 100;
        calculation = new Calculation(multiplication);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("CalculationTest.tearDown");
        valueA = 0;
        valueB = 0;
        expectedValue = 0;
        calculation = null;
    }

    @Test
    public void multiply10() {
        System.out.println("CalculationTest.multiply10");

        //configure the mock to return fakeMultiple
        when(multiplication.multiply(valueA, 40)).thenReturn(fakeMultiple);

        //test calculation multiple with fake multiple
        assertEquals(expectedMultiple, calculation.multiply10(valueA, valueB));

    }

    @Test
    public void add() {
        System.out.println("CalculationTest.add");
        assertEquals(expectedValue, calculation.add(valueA, valueB));
    }

}