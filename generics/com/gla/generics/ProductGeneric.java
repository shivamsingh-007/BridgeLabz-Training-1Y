package com.gla.generics;

public class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void applyDiscount(double percentage) {
        double discount = price * (percentage / 100);
        price -= discount;
    }

    public double getDiscountedPrice(double percentage) {
        return price * (1 - percentage / 100);
    }

    @Override
    public String toString() {
        return name + " (" + category.getCategoryName() + ") - $" + price;
    }
}
