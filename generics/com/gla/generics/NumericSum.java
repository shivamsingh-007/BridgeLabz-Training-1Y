package com.gla.generics;

import java.util.List;

public class NumericSum {
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        java.util.ArrayList<Integer> intList = new java.util.ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("Sum of integers: " + sumNumbers(intList));

        java.util.ArrayList<Double> doubleList = new java.util.ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(2.5);
        doubleList.add(3.0);
        System.out.println("Sum of doubles: " + sumNumbers(doubleList));

        java.util.ArrayList<Long> longList = new java.util.ArrayList<>();
        longList.add(100L);
        longList.add(200L);
        System.out.println("Sum of longs: " + sumNumbers(longList));
    }
}
