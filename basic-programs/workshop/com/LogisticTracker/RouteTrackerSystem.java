package com.LogisticTracker;

public class RouteTrackerSystem {

    public static void main(String[] args) {

        Driver driver = new Driver("D1204", "Kavita Nair");

        // DeliveryCheckpoint – Warehouse A
        driver.addCheckpoint(new DeliveryCheckpoint("CP001", "Warehouse A", 30.0, 30, 40));

        // FuelCheckpoint – Pump 12
        driver.addCheckpoint(new FuelCheckpoint("CP002", "Pump 12", 20.0, 15, 15));

        // RestCheckpoint – Motel X
        driver.addCheckpoint(new RestCheckpoint("CP003", "Motel X", 40.0, 55, 60));

        // DeliveryCheckpoint – Client Hub
        driver.addCheckpoint(new DeliveryCheckpoint("CP004", "Client Hub", 30.0, 45, 60));

        System.out.println("===========================================");
        driver.printRouteSummary();
        System.out.println("===========================================");

        System.out.println();

        // Demo: find a checkpoint
        Checkpoint found = driver.findCheckpoint("CP002");
        if (found != null) {
            System.out.println("Found Checkpoint: " + found.getType() + " at " + found.getLocationName());
        }

        System.out.println();

        // Demo: remove a checkpoint and re-check consistency
        System.out.println("Removing FuelCheckpoint (CP002)...");
        driver.removeCheckpoint("CP002");
        System.out.println("Consistency after removal: " +
                (driver.getRouteHistory().consistencyCheck()
                        ? "All required checkpoints present"
                        : "FAILED – Missing critical checkpoints"));
    }
}
