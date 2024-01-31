package com.hr.personnel.client;

import com.hr.personnel.Department;
import com.hr.personnel.Employee;
import com.hr.personnel.SalariedEmployee;

import java.time.LocalDate;

class HRClient {
    public static void main(String[] args) {
        Employee emp = new SalariedEmployee("Aaron", LocalDate.of(2018, 07, 31),10000);
        return ;
    }
}