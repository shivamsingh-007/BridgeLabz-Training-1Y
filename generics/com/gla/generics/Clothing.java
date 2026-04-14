package com.gla.generics;

public class Clothing extends Cart<String> {
    public void addClothing(String item) {
        addItem(item);
    }
}
