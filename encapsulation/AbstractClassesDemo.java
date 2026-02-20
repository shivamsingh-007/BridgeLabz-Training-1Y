public class AbstractClassesDemo {

    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 180);
        Vehicle bike = new Bike("Yamaha", 120);
        Vehicle truck = new Truck("Volvo", 100);

        car.start();
        car.displayInfo();

        bike.start();
        bike.displayInfo();

        truck.start();
        truck.displayInfo();
    }
}

abstract class Vehicle {
    private String brand;
    private int maxSpeed;

    public Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public final void start() {
        System.out.println(brand + " is starting...");
    }

    public abstract void displayInfo();
}

class Car extends Vehicle {
    private int seatCapacity;

    public Car(String brand, int maxSpeed) {
        super(brand, maxSpeed);
        this.seatCapacity = 5;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + getBrand() + ", Max Speed: " + getMaxSpeed() + ", Seats: " + seatCapacity);
    }
}

class Bike extends Vehicle {
    public Bike(String brand, int maxSpeed) {
        super(brand, maxSpeed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike: " + getBrand() + ", Max Speed: " + getMaxSpeed());
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String brand, int maxSpeed) {
        super(brand, maxSpeed);
        this.loadCapacity = 10.0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck: " + getBrand() + ", Max Speed: " + getMaxSpeed() + ", Load: " + loadCapacity + " tons");
    }
}
