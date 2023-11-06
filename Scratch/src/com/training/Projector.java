package com.training;

class Projector {

    public Projector(){
        System.out.println("Projector ctor called");
    }

    //executres when ClassLoader loads Projector.class into memory
    static {
        System.out.println("Projector.class loaded into memory");
    }
}
