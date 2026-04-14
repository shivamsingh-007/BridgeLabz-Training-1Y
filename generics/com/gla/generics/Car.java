package com.gla.generics;

public class Car extends Vehicle {
    private int doors;

    public Car(String model, int year, int doors) {
        super(model, year);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + doors + " doors)";
    }
}
