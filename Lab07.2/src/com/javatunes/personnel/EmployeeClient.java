package com.javatunes.personnel;

class EmployeeClient {

    public static void main(String[] args) {
        Employee emp = new Employee();

        long begin = System.nanoTime();

        emp.work();
        emp.pay();

        long end = System.nanoTime();

        double total = (end - begin) / 1_000_000.0;
        System.out.println(total + "ms");
    }
}
