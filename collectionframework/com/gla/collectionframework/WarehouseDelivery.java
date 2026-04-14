package com.gla.collectionframework;

import java.util.*;

public class WarehouseDelivery {
    private Queue<Package> incomingPackages;
    private Set<String> deliveredPackageIds;
    private List<Package> allPackages;
    private Stack<Package> deliveryStack;

    public WarehouseDelivery() {
        this.incomingPackages = new LinkedList<>();
        this.deliveredPackageIds = new HashSet<>();
        this.allPackages = new ArrayList<>();
        this.deliveryStack = new Stack<>();
    }

    public void receivePackage(Package pkg) {
        allPackages.add(pkg);
        incomingPackages.offer(pkg);
    }

    public void deliverPackage() {
        Package pkg = incomingPackages.poll();
        if (pkg != null) {
            pkg.deliver();
            deliveredPackageIds.add(pkg.getPackageId());
            deliveryStack.push(pkg);
        }
    }

    public void undoLastDelivery() {
        if (!deliveryStack.isEmpty()) {
            Package pkg = deliveryStack.pop();
            deliveredPackageIds.remove(pkg.getPackageId());
            incomingPackages.offer(pkg);
            System.out.println("Undone delivery: " + pkg.getPackageId());
        }
    }

    public List<Package> getPackagesByDestination(String destination) {
        List<Package> destPackages = new ArrayList<>();
        for (Package p : allPackages) {
            if (p.getDestination().equals(destination)) {
                destPackages.add(p);
            }
        }
        return destPackages;
    }

    public Set<String> getDeliveredPackageIds() {
        return deliveredPackageIds;
    }

    public int getPendingCount() {
        return incomingPackages.size();
    }

    public static void main(String[] args) {
        WarehouseDelivery warehouse = new WarehouseDelivery();
        warehouse.receivePackage(new Package("PK001", "NYC", 2.5));
        warehouse.receivePackage(new Package("PK002", "LA", 1.2));
        warehouse.receivePackage(new Package("PK003", "NYC", 3.0));
        System.out.println("Pending: " + warehouse.getPendingCount());
        warehouse.deliverPackage();
        warehouse.deliverPackage();
        System.out.println("Delivered: " + warehouse.getDeliveredPackageIds());
        warehouse.undoLastDelivery();
        System.out.println("Pending after undo: " + warehouse.getPendingCount());
    }
}

class Package {
    private String packageId;
    private String destination;
    private double weight;

    public Package(String packageId, String destination, double weight) {
        this.packageId = packageId;
        this.destination = destination;
        this.weight = weight;
    }

    public void deliver() {
        System.out.println("Delivering package " + packageId + " to " + destination);
    }

    public String getPackageId() { return packageId; }
    public String getDestination() { return destination; }
    public double getWeight() { return weight; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package pkg = (Package) o;
        return Objects.equals(packageId, pkg.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId);
    }
}
