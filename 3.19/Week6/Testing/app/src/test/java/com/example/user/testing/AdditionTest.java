package com.example.user.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Addition.class)
public class AdditionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
    }

    @Test
    public void test_some_constant() {

        PowerMockito.mockStatic(Addition.class);

        when(Addition.getSomeConstant()).thenReturn(50);
        assertEquals(50, Addition.getSomeConstant());

    }
}