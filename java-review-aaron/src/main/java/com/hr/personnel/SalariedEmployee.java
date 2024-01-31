package com.hr.personnel;

import java.time.LocalDate;

public class SalariedEmployee extends Employee{
    double salary;


    public SalariedEmployee(String name, LocalDate hireDate, double salary) {
        super(name, hireDate);
        setSalary(this.salary);
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
