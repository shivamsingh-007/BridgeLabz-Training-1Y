package com.gla.array.level2;

import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
            double w = scanner.nextDouble();
            if (w <= 0) {
                System.out.println("Please enter a positive value.");
                i--;
                continue;
            }
            System.out.print("Enter height of person " + (i + 1) + " (cm): ");
            double h = scanner.nextDouble();
            if (h <= 0) {
                System.out.println("Please enter a positive value.");
                i--;
                continue;
            }
            personData[i][0] = w;
            personData[i][1] = h;
            double heightM = h / 100;
            personData[i][2] = w / (heightM * heightM);
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25.0) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 30.0) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("Person | Weight(kg) | Height(cm) | BMI    | Status");
        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + "      | " + personData[i][0] + "       | " + personData[i][1] + "       | " + personData[i][2] + " | " + weightStatus[i]);
        }
        scanner.close();
    }
}
