public class VehicleTransportSystem {

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Petrol", 200, 5);
        vehicles[1] = new Truck("Diesel", 120, 20.0);
        vehicles[2] = new Motorcycle("Petrol", 180);

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }
}

class Vehicle {
    private int maxSpeed;
    private String fuelType;

    public Vehicle(String fuelType, int maxSpeed) {
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void displayInfo() {
        System.out.println("Vehicle - Fuel: " + fuelType + ", Max Speed: " + maxSpeed + " km/h");
    }
}

class Car extends Vehicle {
    private int seatCapacity;

    public Car(String fuelType, int maxSpeed, int seatCapacity) {
        super(fuelType, maxSpeed);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car - Fuel: " + getFuelType() + ", Max Speed: " + getMaxSpeed() + " km/h, Seats: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String fuelType, int maxSpeed, double loadCapacity) {
        super(fuelType, maxSpeed);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck - Fuel: " + getFuelType() + ", Max Speed: " + getMaxSpeed() + " km/h, Load: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {

    public Motorcycle(String fuelType, int maxSpeed) {
        super(fuelType, maxSpeed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Motorcycle - Fuel: " + getFuelType() + ", Max Speed: " + getMaxSpeed() + " km/h");
    }
}
