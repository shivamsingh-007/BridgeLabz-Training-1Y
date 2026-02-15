package com.gla.array.level1;

import java.util.Scanner;

public class MeanHeightFootball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }
        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];
        }
        double mean = sum / 11;
        System.out.println("Mean height of the football team = " + mean + " cm");
        scanner.close();
    }
}
