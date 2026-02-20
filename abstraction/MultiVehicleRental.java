public class MultiVehicleRental {

    public static void main(String[] args) {
        RentalVehicle car = new RentalCar();
        RentalVehicle bike = new RentalBike();
        RentalVehicle bus = new RentalBus();

        car.rent();
        car.returnVehicle();
        bike.rent();
        bike.returnVehicle();
        bus.rent();
        bus.returnVehicle();
    }
}

interface RentalVehicle {
    void rent();
    void returnVehicle();
}

class RentalCar implements RentalVehicle {
    @Override
    public void rent() {
        System.out.println("Car rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car returned successfully");
    }
}

class RentalBike implements RentalVehicle {
    @Override
    public void rent() {
        System.out.println("Bike rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike returned successfully");
    }
}

class RentalBus implements RentalVehicle {
    @Override
    public void rent() {
        System.out.println("Bus rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus returned successfully");
    }
}
