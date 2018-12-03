package com.example.user.testing.calc;

import com.example.user.testing.ListProvider;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculationTest {

    private int valueA;
    private int valueB;
    private int expectedValue;
    private Calculation calculation;
    private int fakeMultiple;
    private int expectedMultiple;

    @Mock
    private
    Multiplication multiplication;

    private Subtraction subtraction;

    @Mock
    private
    ListProvider listProvider;

    @BeforeClass
    public static void setupClass() {
        System.out.println("CalculationTest.setupClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("CalculationTest.tearDownClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("CalculationTest.setUp");

        //mocking using field injection
        MockitoAnnotations.initMocks(this);

//        mocking using method injection
        subtraction = mock(Subtraction.class);

        valueA = 10;
        valueB = 20;
        expectedValue = 30;
        fakeMultiple = 10;
        expectedMultiple = 100;
        calculation = new Calculation(multiplication, subtraction, listProvider);
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
        when(multiplication.multiply(valueA, valueB)).thenReturn(fakeMultiple);

        //test calculation multiple with fake multiple
        assertEquals(expectedMultiple, calculation.multiply10(valueA, valueB));

    }

    @Test
    public void add() {
        System.out.println("CalculationTest.add");
        assertEquals(expectedValue, calculation.add(valueA, valueB));
    }

    @Test
    public void subtract() {
        System.out.println("CalculationTest.subtract");

        calculation.subtract(valueA, valueB);
        verify(subtraction).subtract(valueA+1, valueB);

    }

    @Test
    public void getList() throws Exception{

        when(listProvider.getRawList()).thenReturn(getFakeList());

        assertEquals(getExpectedList(), calculation.getList());

    }


    //util method
    private List<String> getFakeList() {
        List<String> fakeList = new ArrayList<>();
        fakeList.add("E");
        return fakeList;
    }

    private List<String> getExpectedList(){
        List<String> expectedList = new ArrayList<>();
        expectedList.add("E");
        expectedList.add("F");
        return expectedList;
    }
}