package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> productPrices = new LinkedHashMap<>();
        
        productPrices.put("Laptop", 999.99);
        productPrices.put("Smartphone", 699.50);
        productPrices.put("Tablet", 449.00);
        productPrices.put("Headphones", 149.99);
        productPrices.put("Smartwatch", 299.00);
        productPrices.put("Camera", 599.00);
        
        System.out.println("Product Prices:");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue());
        }
        
        List<Map.Entry<String, Double>> sortedByPrice = new ArrayList<>(productPrices.entrySet());
        sortedByPrice.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
        
        System.out.println("\nProducts by Price (High to Low):");
        for (Map.Entry<String, Double> entry : sortedByPrice) {
            System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue());
        }
        
        double averagePrice = productPrices.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.printf("\nAverage Price: $%.2f%n", averagePrice);
        
        double maxPrice = Collections.max(productPrices.values());
        double minPrice = Collections.min(productPrices.values());
        System.out.printf("Most Expensive: $%.2f%n", maxPrice);
        System.out.printf("Least Expensive: $%.2f%n", minPrice);
        
        productPrices.put("Earbuds", 79.99);
        System.out.println("\nAdded Earbuds. Total products: " + productPrices.size());
        
        productPrices.remove("Camera");
        System.out.println("After removing Camera: " + productPrices.size() + " products");
    }
}
