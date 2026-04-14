package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        
        inventory.put("Laptop", 50);
        inventory.put("Mouse", 200);
        inventory.put("Keyboard", 150);
        inventory.put("Monitor", 75);
        inventory.put("Headphones", 300);
        
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " units");
        }
        
        inventory.put("Laptop", inventory.get("Laptop") - 5);
        System.out.println("\nAfter selling 5 laptops: " + inventory.get("Laptop") + " remaining");
        
        inventory.put("Webcam", 100);
        System.out.println("\nAdded Webcam: " + inventory.get("Webcam") + " units");
        
        System.out.println("\nLow Stock Items (< 100 units):");
        inventory.forEach((product, quantity) -> {
            if (quantity < 100) {
                System.out.println(product + ": " + quantity);
            }
        });
        
        System.out.println("\nTotal Products: " + inventory.size());
        System.out.println("Total Units: " + inventory.values().stream().mapToInt(Integer::intValue).sum());
        
        inventory.remove("Mouse");
        System.out.println("\nRemoved Mouse. Current size: " + inventory.size());
    }
}
