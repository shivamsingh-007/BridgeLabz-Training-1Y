package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Order> orders = new LinkedHashMap<>();
        
        orders.put("ORD001", new Order("ORD001", "Laptop", 2, 1500.00));
        orders.put("ORD002", new Order("ORD002", "Phone", 1, 800.00));
        orders.put("ORD003", new Order("ORD003", "Headphones", 5, 50.00));
        
        System.out.println("All Orders:");
        for (Map.Entry<String, Order> entry : orders.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        
        System.out.println("\nOrder ORD002: " + orders.get("ORD002"));
        
        System.out.println("\nTotal Orders: " + orders.size());
        
        orders.remove("ORD001");
        System.out.println("\nAfter removing ORD001: " + orders.size() + " orders");
        
        System.out.println("\nOrders with value > 500:");
        for (Order order : orders.values()) {
            if (order.getTotalValue() > 500) {
                System.out.println(order);
            }
        }
    }
}

class Order {
    private String orderId;
    private String product;
    private int quantity;
    private double price;
    
    public Order(String orderId, String product, int quantity, double price) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getOrderId() { return orderId; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getTotalValue() { return quantity * price; }
    
    @Override
    public String toString() {
        return orderId + " | " + product + " | Qty: " + quantity + " | Price: $" + price + " | Total: $" + getTotalValue();
    }
}
