package com.example.user.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by singh on 10/3/17.
 */

public class CalculationTest {


    private Calculation calculation;
    private Addition addition;


    @Before
    public void setup() {

        addition = mock(Addition.class);
        Addition addition1 = new Addition();
        calculation = new Calculation(addition);

        calculation.setVal1(10);
        calculation.setVal2(5);

    }


    @Test
    public void should_add_the_input_numbers() {

        //test the logic of the addition function in the calculation class

        when(addition.add(10,5))
                .thenReturn(10)
                .thenReturn(5);

        assertEquals(calculation.addition(), 25);

    }

    @Test
    public void should_subtract_the_input_numbers(){

        assertEquals(calculation.subtraction(), 5);

    }

    @Test
    public void should_divide_the_input_numbers(){

        assertEquals(calculation.division(), 2.25,1.0);
    }


    @After
    public void tearDown(){

        calculation.clear();

    }





}
