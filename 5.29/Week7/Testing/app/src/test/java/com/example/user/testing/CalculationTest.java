package com.example.user.testing;


import android.graphics.drawable.AdaptiveIconDrawable;
import android.text.TextUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculationTest {

    private static final int PARAM1 = 3;
    private static final int PARAM2 = 4;
    private static final int EXPECTED = 12;


    Calculation calculation;

    @Mock
    Addition addition;


    @BeforeClass
    public static void setupClass() {
        System.out.println("setupClass");
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        calculation = new Calculation(addition);
        System.out.println("setup" + calculation.toString());

    }

    @Test
    public void add() {

        System.out.println("add");
    }


    @After
    public void tearDown() throws Exception {

        calculation = null;
        System.out.println("after1");

    }

    @Test
    public void multiply() {

        System.out.println("multiply");
        assertEquals(EXPECTED, calculation.multiply(PARAM1, PARAM2));

    }

    @After
    public void tearDown2() {
        System.out.println("after2");
    }

    @Test
    public void addTen() {

//        mock addition add method
        when(addition.add(PARAM1, PARAM2)).thenReturn(5);

        assertEquals(15, calculation.addTen(PARAM1, PARAM2));

    }


    @Test
    public void something() {
        calculation.something();
        verify(addition).something();
    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void divide() {

        try {

            calculation.divide(PARAM1, 0);
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), containsString("/ by zero"));

        }

    }

    @Test
    public void divide_with_rule() {
        exception.expect(ArithmeticException.class);
        exception.expectMessage(containsString("/ by zero"));
        calculation.divide(PARAM1, 0);


    }

    @Test(expected = ArithmeticException.class)
    public void otherDivide() {
        calculation.divide(PARAM1, 0);
    }

    @Test
    public void getList() {

        List<String> expectedList = Arrays.asList("A", "B", "C");

//        compare the list
        assertThat(calculation.getList(), is(expectedList));

//        check for a item in the list
//        assertThat(calculation.getList(), hasItem("B"));



    }



}