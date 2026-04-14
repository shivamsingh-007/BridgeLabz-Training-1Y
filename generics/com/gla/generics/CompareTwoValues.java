package com.gla.generics;

public class CompareTwoValues {
    public static <T> boolean isEqual(T a, T b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println("Integer equality: " + isEqual(10, 10));
        System.out.println("Integer inequality: " + isEqual(10, 20));
        System.out.println("String equality: " + isEqual("Hello", "Hello"));
        System.out.println("String inequality: " + isEqual("Hello", "World"));
        System.out.println("Double equality: " + isEqual(3.14, 3.14));
        System.out.println("Double inequality: " + isEqual(3.14, 2.71));
    }
}
