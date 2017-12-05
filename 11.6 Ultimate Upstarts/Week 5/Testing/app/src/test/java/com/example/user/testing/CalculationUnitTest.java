package com.example.user.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by singh on 12/5/17.
 */

public class CalculationUnitTest {


    Calculation calculation;
    Addition addition;

    @Before
    public void setup(){

        addition = mock(Addition.class);
        calculation = new Calculation(addition);
        calculation.setVal1(5);
        calculation.setVal2(10);

    }

    @Test
    public void add_Should_add_two_numbers(){
        when(addition.add(5,10)).thenReturn(30);
        assertEquals(calculation.add(), 40);
    }

    @Test
    public void should_invoke_something(){

        calculation.add();
        verify(addition, times(2)).something();
    }

    @After
    public void tearDown(){

    }
}
