package com.example.user.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by singh on 2/16/18.
 */

public class CalculationUnitTest {

    Calculation calculation;
    private int sampleA;
    private int sampleB;
    private int result;

    @Mock
    Addition addition;

    @Mock
    Multiplication multiplication;

    private int mockedResult;
    private int resultAddTen;
    private int resultMultiplyTen;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        calculation = new Calculation(addition, multiplication);

        sampleA = 4;
        sampleB = 7;
        result = 11;
        mockedResult = 50;
        resultAddTen = mockedResult + 10;

        resultMultiplyTen = mockedResult * 10;

    }

    @Test
    public void should_add_numbers() {

        assertEquals(result, calculation.add(sampleA, sampleB));

    }

    @Test
    public void should_add_ten_to_result() {

        when(addition.add(sampleA, sampleB)).thenReturn(mockedResult);
        assertEquals(resultAddTen, calculation.addTen(sampleA, sampleB));
    }

    @Test
    public void should_multiply_ten_to_result() {

        when(multiplication.multiply(sampleA, sampleB)).thenReturn(mockedResult);
        assertEquals(resultMultiplyTen, calculation.multiplyTen(sampleA, sampleB));
    }

    @After
    public void tearDown() {

        calculation.clearValues();
    }


}
