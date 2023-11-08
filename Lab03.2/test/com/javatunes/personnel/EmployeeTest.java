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
        // emp = new DummyEmployee("Mary", Date.valueOf("2020-06-01"));
        // emp2 = new DummyEmployee("Mary", Date.valueOf("2020-06-01"));

        emp = new Employee("Mary", Date.valueOf("2020-06-01")) {
            public double pay() {
                return 0;
            }
            public double payTaxes() {
                return 0;
            }
        };

        emp2 = new Employee("Mary", Date.valueOf("2020-06-01")) {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
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

    //named member level inner classes
    private class DummyEmployee extends Employee{

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}