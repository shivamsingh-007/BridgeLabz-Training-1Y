package com.gla.generics;

import java.util.List;

public class PriceCalculator {
    public static double calculateTotal(List<? extends Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        java.util.ArrayList<Product> products = new java.util.ArrayList<>();
        products.add(new Product() {
            public double getPrice() { return 29.99; }
            public String getName() { return "Book"; }
        });
        products.add(new Product() {
            public double getPrice() { return 9.99; }
            public String getName() { return "Pen"; }
        });
        products.add(new Product() {
            public double getPrice() { return 15.50; }
            public String getName() { return "Notebook"; }
        });

        System.out.println("Products in cart:");
        for (Product p : products) {
            System.out.println("  - " + p.getName() + ": $" + p.getPrice());
        }
        System.out.println("Total: $" + calculateTotal(products));
    }
}
