package com.example.user.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculationTest {

    Calculation calculation;
    int MOCK_INCREMENT = 10;
    int a;
    int b;

    List<Object> expectedList;

    @Mock
    Addition addition;

    @Mock
    Multiplication multiplication;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

//        another way to mock an object using mockito
//        addition = mock(Addition.class);
        calculation = new Calculation(addition, multiplication, MOCK_INCREMENT);
        a = 10;
        b = 20;

        expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void add() {

        when(addition.add(a, b)).thenReturn(50);
        assertEquals(60, calculation.add(a, b));

    }

    @Test
    public void addSimple() {

        assertEquals(31, calculation.addSimple(a, b));

    }

    @Test
    public void getSampleList() {
        assertThat(expectedList, is(calculation.getSampleList()));
    }


    @Test
    public void setupAddition() {

        calculation.setupAddition();
        verify(addition).setup();
    }


}