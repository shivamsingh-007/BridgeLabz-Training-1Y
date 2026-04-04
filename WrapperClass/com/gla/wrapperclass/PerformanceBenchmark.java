package com.gla.wrapperclass;

import java.util.ArrayList;

public class PerformanceBenchmark {
    public static void main(String[] args) {
        int size = 1000000;

        ArrayList<Integer> integerList = new ArrayList<>();
        long startFill1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integerList.add(i);
        }
        long endFill1 = System.currentTimeMillis();
        System.out.println("ArrayList<Integer> fill time: " + (endFill1 - startFill1) + " ms");

        int[] intArray = new int[size];
        long startFill2 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            intArray[i] = i;
        }
        long endFill2 = System.currentTimeMillis();
        System.out.println("int[] fill time: " + (endFill2 - startFill2) + " ms");

        long sum1 = 0;
        long startSum1 = System.currentTimeMillis();
        for (Integer val : integerList) {
            sum1 += val;
        }
        long endSum1 = System.currentTimeMillis();
        System.out.println("\nArrayList<Integer> sum: " + sum1);
        System.out.println("ArrayList<Integer> sum time: " + (endSum1 - startSum1) + " ms");

        long sum2 = 0;
        long startSum2 = System.currentTimeMillis();
        for (int val : intArray) {
            sum2 += val;
        }
        long endSum2 = System.currentTimeMillis();
        System.out.println("\nint[] sum: " + sum2);
        System.out.println("int[] sum time: " + (endSum2 - startSum2) + " ms");

        System.out.println("\n--- Summary ---");
        System.out.println("int[] is faster due to no boxing/unboxing overhead.");
    }
}
