package com.gla.generics;

public class Truck extends Vehicle {
    private double capacity;

    public Truck(String model, int year, double capacity) {
        super(model, year);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " (Capacity: " + capacity + " tons)";
    }
}
