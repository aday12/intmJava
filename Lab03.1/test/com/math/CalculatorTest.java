/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
    //fixture: business obj(s) were testing
    private Calculator calc;

    @BeforeClass
    public static void initializeTestRun(){
        System.out.println("initializeTestRun");
    }

    @AfterClass
    public static void finalizeTestRun(){
        System.out.println("finalizeTestRun");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");

        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(1, 4));  // expected, actual

        System.out.println("testAdd");
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), .001);

        System.out.println("testDivide");
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");

        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(11));
    }
}