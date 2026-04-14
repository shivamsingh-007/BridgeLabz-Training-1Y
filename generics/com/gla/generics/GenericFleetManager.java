package com.gla.generics;

import java.util.ArrayList;
import java.util.List;

public class FleetManager<T extends Vehicle> {
    private List<T> vehicles;

    public FleetManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(T vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(T vehicle) {
        vehicles.remove(vehicle);
    }

    public List<T> getVehicles() {
        return vehicles;
    }

    public static void main(String[] args) {
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Volvo FMX", 2022, 25.0));
        truckFleet.addVehicle(new Truck("Scania R500", 2023, 30.0));
        System.out.println("Truck Fleet:");
        for (Truck t : truckFleet.getVehicles()) {
            System.out.println("  - " + t);
        }

        FleetManager<Car> carFleet = new FleetManager<>();
        carFleet.addVehicle(new Car("Toyota Camry", 2023, 4));
        carFleet.addVehicle(new Car("Honda Civic", 2022, 4));
        System.out.println("Car Fleet:");
        for (Car c : carFleet.getVehicles()) {
            System.out.println("  - " + c);
        }

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Yamaha MT-15", 2023, 155));
        bikeFleet.addVehicle(new Bike("KTM Duke 390", 2022, 373));
        System.out.println("Bike Fleet:");
        for (Bike b : bikeFleet.getVehicles()) {
            System.out.println("  - " + b);
        }
    }
}
