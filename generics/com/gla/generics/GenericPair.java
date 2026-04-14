package com.gla.generics;

public class GenericPair<T, U> {
    private T first;
    private U second;

    public GenericPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public static void main(String[] args) {
        GenericPair<String, Integer> pair1 = new GenericPair<>("Age", 25);
        System.out.println("First: " + pair1.getFirst() + ", Second: " + pair1.getSecond());

        GenericPair<Double, String> pair2 = new GenericPair<>(3.14, "Pi");
        System.out.println("First: " + pair2.getFirst() + ", Second: " + pair2.getSecond());

        GenericPair<Boolean, Character> pair3 = new GenericPair<>(true, 'Y');
        System.out.println("First: " + pair3.getFirst() + ", Second: " + pair3.getSecond());
    }
}
