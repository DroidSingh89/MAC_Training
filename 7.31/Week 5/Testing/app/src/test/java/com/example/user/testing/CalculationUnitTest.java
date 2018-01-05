package com.example.user.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Created by singh on 8/29/17.
 */



public class CalculationUnitTest {

    Calculation calculation;


    Addition addition;
    Multiplication multiplication;
    Subtraction subtraction;
    Division division;


    @Before
    public void Setup(){

        addition = mock(Addition.class);
        multiplication = mock(Multiplication.class);
        subtraction = mock(Subtraction.class);
        division = mock(Division.class);

        calculation = new Calculation(addition, subtraction, multiplication, division);
        calculation.setVal1(9);
        calculation.setVal2(9);

    }


    @Test
    public void testing_addition_should_add_two_numbers(){

        when(addition.add(9,9)).thenReturn(27);

        assertEquals(calculation.addition(), 32);
    }

    @Test
    public void testing_addition_should_subtract_two_numbers(){

        when(subtraction.subtact(9,9)).thenReturn(5);

        assertEquals(calculation.subtraction(), 10);
    }

    @After
    public void tearDown(){

        calculation.clear();


    }

}
