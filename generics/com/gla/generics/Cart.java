package com.gla.generics;

import java.util.ArrayList;
import java.util.List;

public class Cart<T> {
    private List<T> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayItems() {
        System.out.println("Cart contains " + items.size() + " items:");
        for (T item : items) {
            System.out.println("  - " + item);
        }
    }
}
