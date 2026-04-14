package com.gla.collectionframework;

import java.util.*;

public class ECommerceOrderProcessing {
    private List<Order> orderList;
    private Set<String> processedOrderIds;
    private Queue<Order> pendingOrders;
    private Stack<Order> orderHistory;

    public ECommerceOrderProcessing() {
        this.orderList = new ArrayList<>();
        this.processedOrderIds = new HashSet<>();
        this.pendingOrders = new LinkedList<>();
        this.orderHistory = new Stack<>();
    }

    public void addOrder(Order order) {
        orderList.add(order);
        pendingOrders.offer(order);
    }

    public void processOrder() {
        Order order = pendingOrders.poll();
        if (order != null) {
            order.process();
            processedOrderIds.add(order.getOrderId());
            orderHistory.push(order);
        }
    }

    public void undoLastProcessed() {
        if (!orderHistory.isEmpty()) {
            Order order = orderHistory.pop();
            processedOrderIds.remove(order.getOrderId());
            pendingOrders.offer(order);
        }
    }

    public List<Order> getOrdersByCustomer(String customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getCustomerId().equals(customerId)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    public Set<String> getProcessedOrderIds() {
        return processedOrderIds;
    }

    public int getPendingCount() {
        return pendingOrders.size();
    }

    public static void main(String[] args) {
        ECommerceOrderProcessing processor = new ECommerceOrderProcessing();
        processor.addOrder(new Order("O001", "C001", 150.00));
        processor.addOrder(new Order("O002", "C002", 200.00));
        processor.addOrder(new Order("O003", "C001", 75.00));
        System.out.println("Pending orders: " + processor.getPendingCount());
        processor.processOrder();
        System.out.println("Processed IDs: " + processor.getProcessedOrderIds());
        processor.undoLastProcessed();
        System.out.println("Pending after undo: " + processor.getPendingCount());
    }
}

class Order {
    private String orderId;
    private String customerId;
    private double amount;

    public Order(String orderId, String customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public void process() {
        System.out.println("Processing order: " + orderId);
    }

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public double getAmount() { return amount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
