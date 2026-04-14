package com.gla.generics;

public class GenericBox<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }

    public static void main(String[] args) {
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.set(42);
        System.out.println("Integer Box: " + intBox.get());

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello Generics");
        System.out.println("String Box: " + stringBox.get());

        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(3.14159);
        System.out.println("Double Box: " + doubleBox.get());
    }
}
