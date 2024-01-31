package com.hr.personnel;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    String location;
//    Employee[] employees = new Employee[100];
    private List<Employee> employees = new ArrayList<>();

    void addEmployee(Employee emp){
//        employees[currIndex] = emp;
//        employees[currIndex++] = emp;

        employees.add(emp);

    }

    int employeesWhoWorked(){
        return 0;
    }
}
