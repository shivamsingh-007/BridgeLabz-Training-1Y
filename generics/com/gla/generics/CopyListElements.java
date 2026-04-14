package com.gla.generics;

import java.util.List;

public class CopyListElements {
    public static <T> void copyList(List<? super T> dest, List<? extends T> src) {
        for (T item : src) {
            dest.add(item);
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Number> destNumbers = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> srcIntegers = new java.util.ArrayList<>();
        srcIntegers.add(1);
        srcIntegers.add(2);
        srcIntegers.add(3);
        copyList(destNumbers, srcIntegers);
        System.out.println("Copied to Number list: " + destNumbers);

        java.util.ArrayList<Object> destObjects = new java.util.ArrayList<>();
        java.util.ArrayList<Double> srcDoubles = new java.util.ArrayList<>();
        srcDoubles.add(1.1);
        srcDoubles.add(2.2);
        copyList(destObjects, srcDoubles);
        System.out.println("Copied to Object list: " + destObjects);
    }
}
