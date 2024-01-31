package com.hr.personnel;

import java.time.LocalDate;

public abstract class Employee {
    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public Employee() {

    }

    public String getEmployeeInfo(){
        return name + " was hired on: " + hireDate;
    }

    public String work() {
        return name + " worked.";
    }
}
