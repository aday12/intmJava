package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp;
    private Employee emp2;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("Mary", Date.valueOf("2020-06-01"));
        emp2 = new SalariedEmployee("Mary", Date.valueOf("2020-06-01"));
    }

    // ask at work if we need to do repetitive testing on abstract classes/interfaces
    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Jenny");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2000-02-02"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);
    }
}