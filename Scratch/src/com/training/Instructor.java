package com.training;

class Instructor {
    //share among all Instructors
    private static Projector projector = new Projector();

    // instance variables for each Instructor object
    private final String name;
    private final int yearsExperience;

    public Instructor(String name, int yearsExperience) {
        System.out.println("Instructor ctor called");
        this.name = name;
        this.yearsExperience = yearsExperience;
    }

    public static void touch() {
        System.out.println("touch() called");
    }

    //accessor methods
    public String getName() {
        return name;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    static {
        System.out.println("static fields initialized, Instructor.class loaded into memory");
    }
}
