package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("Aaron", Date.valueOf("2020-02-06"), 1500.0);
        emp2 = new SalariedEmployee("Aaron", Date.valueOf("2020-02-06"), 1500.0);
    }

    @Test
    public void hashCode_equalObjectsMustHaveEqualHashCodes() {
        assertEquals(emp.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_returnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("Megan");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2020-01-06"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1000.0);
        assertNotEquals(emp, emp2);
        assertFalse(emp.equals(emp2));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);      //equals()
        assertTrue(emp.equals(emp2)); // alternative assertion
    }

    @Test
    public void testPaySal() {
        assertEquals(1500, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, emp.payTaxes(), .001);
    }
}