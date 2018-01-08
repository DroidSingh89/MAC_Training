package com.example.user.testing;

import android.annotation.TargetApi;
import android.os.Build;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by singh on 1/4/18.
 */

public class CalculationUnitTest {

    Calculation calculation;
    int val1,val2;

    Addition addition;

    @Mock
    Multiplication multiplication;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        val1 = 5;
        val2 = 10;

        addition = mock(Addition.class);
        calculation = new Calculation(addition, multiplication);

    }


    @Test
    public void should_add_two_Numbers() {

        when(addition.add(val1, val2)).thenReturn(30);
        assertEquals(calculation.add(val1,val2), 40);
    }
    @Test
    public void should_multiply_two_Numbers() {

        when(multiplication.multiply(val1, val2)).thenReturn(45);
        assertEquals(calculation.multipy(val1,val2), 450);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Test
    public void was_methos_Called() {

    }

    @After
    public void tearDown() {
        //clear any ref used by calculation
    }
}
