package com.gla.generics;

public class Bike extends Vehicle {
    private int engineCC;

    public Bike(String model, int year, int engineCC) {
        super(model, year);
        this.engineCC = engineCC;
    }

    public int getEngineCC() {
        return engineCC;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + engineCC + " CC)";
    }
}
