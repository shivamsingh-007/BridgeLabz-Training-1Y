package com.gla.generics;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }

    public static void main(String[] args) {
        Storage<ElectronicsItem> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new ElectronicsItem("E001", "Laptop", 24));
        electronicsStorage.addItem(new ElectronicsItem("E002", "Mobile Phone", 12));
        System.out.println("Electronics Storage:");
        for (ElectronicsItem e : electronicsStorage.getItems()) {
            System.out.println("  - " + e);
        }

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G001", "Rice 5kg", "2025-12-31"));
        groceriesStorage.addItem(new Groceries("G002", "Wheat Flour", "2025-06-30"));
        System.out.println("Groceries Storage:");
        for (Groceries g : groceriesStorage.getItems()) {
            System.out.println("  - " + g);
        }

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F001", "Wooden Table", "Oak"));
        furnitureStorage.addItem(new Furniture("F002", "Office Chair", "Mesh"));
        System.out.println("Furniture Storage:");
        for (Furniture f : furnitureStorage.getItems()) {
            System.out.println("  - " + f);
        }
    }
}
