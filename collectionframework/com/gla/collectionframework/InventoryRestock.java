package com.gla.collectionframework;

import java.util.*;

public class InventoryRestock {
    private Set<Product> productCatalog;
    private List<Product> recentOrders;
    private Queue<RestockRequest> restockQueue;
    private Stack<RestockRequest> restockHistory;

    public InventoryRestock() {
        this.productCatalog = new HashSet<>();
        this.recentOrders = new ArrayList<>();
        this.restockQueue = new LinkedList<>();
        this.restockHistory = new Stack<>();
    }

    public void addProduct(Product product) {
        productCatalog.add(product);
    }

    public void placeRestockRequest(RestockRequest request) {
        restockQueue.offer(request);
    }

    public void processRestock() {
        RestockRequest request = restockQueue.poll();
        if (request != null) {
            request.process();
            restockHistory.push(request);
            for (Product p : productCatalog) {
                if (p.getProductId().equals(request.getProductId())) {
                    p.increaseQuantity(request.getQuantity());
                }
            }
        }
    }

    public void undoLastRestock() {
        if (!restockHistory.isEmpty()) {
            RestockRequest request = restockHistory.pop();
            System.out.println("Undone restock for: " + request.getProductId());
        }
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<>();
        for (Product p : productCatalog) {
            if (p.getQuantity() < threshold) {
                lowStock.add(p);
            }
        }
        return lowStock;
    }

    public Set<Product> getProductCatalog() {
        return productCatalog;
    }

    public static void main(String[] args) {
        InventoryRestock inventory = new InventoryRestock();
        inventory.addProduct(new Product("PR001", "Laptop", 5));
        inventory.addProduct(new Product("PR002", "Mouse", 50));
        inventory.addProduct(new Product("PR003", "Keyboard", 3));
        inventory.placeRestockRequest(new RestockRequest("RR001", "PR001", 10));
        inventory.placeRestockRequest(new RestockRequest("RR002", "PR003", 20));
        System.out.println("Queue size: " + inventory.restockQueue.size());
        inventory.processRestock();
        System.out.println("History size: " + inventory.restockHistory.size());
        System.out.println("Low stock: " + inventory.getLowStockProducts(10));
    }
}

class Product {
    private String productId;
    private String name;
    private int quantity;

    public Product(String productId, String name, int quantity) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return name + ": " + quantity;
    }
}

class RestockRequest {
    private String requestId;
    private String productId;
    private int quantity;

    public RestockRequest(String requestId, String productId, int quantity) {
        this.requestId = requestId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public void process() {
        System.out.println("Processing restock: " + productId + " qty: " + quantity);
    }

    public String getRequestId() { return requestId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestockRequest that = (RestockRequest) o;
        return Objects.equals(requestId, that.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId);
    }
}
