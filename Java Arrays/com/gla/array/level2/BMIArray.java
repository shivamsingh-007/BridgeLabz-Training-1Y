package com.gla.array.level2;

import java.util.Scanner;

public class BMIArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();
        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
            weight[i] = scanner.nextDouble();
            System.out.print("Enter height of person " + (i + 1) + " (cm): ");
            height[i] = scanner.nextDouble();
        }
        for (int i = 0; i < number; i++) {
            double heightM = height[i] / 100;
            bmi[i] = weight[i] / (heightM * heightM);
            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] < 25.0) {
                weightStatus[i] = "Normal weight";
            } else if (bmi[i] < 30.0) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("Person | Height(cm) | Weight(kg) | BMI    | Status");
        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + "      | " + height[i] + "       | " + weight[i] + "       | " + bmi[i] + " | " + weightStatus[i]);
        }
        scanner.close();
    }
}
