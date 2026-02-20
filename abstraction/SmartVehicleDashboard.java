public class SmartVehicleDashboard {

    public static void main(String[] args) {
        Dashboard petrolCar = new PetrolCar();
        Dashboard electricCar = new ElectricCar();

        petrolCar.displaySpeed();

        electricCar.displaySpeed();
        electricCar.displayBatteryPercentage();
    }
}

interface Dashboard {
    void displaySpeed();

    default void displayBatteryPercentage() {
        System.out.println("Battery info not available for this vehicle");
    }
}

class PetrolCar implements Dashboard {
    @Override
    public void displaySpeed() {
        System.out.println("Petrol Car current speed: 80 km/h");
    }
}

class ElectricCar implements Dashboard {
    @Override
    public void displaySpeed() {
        System.out.println("Electric Car current speed: 100 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Electric Car battery: 75%");
    }
}
