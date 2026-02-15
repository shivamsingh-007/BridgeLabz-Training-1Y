package com.gla.stringapi.level3;

import java.util.Scanner;

public class BMIOrganization {
    static String getStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal weight";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static String[][] computeBMI(double[][] personData) {
        String[][] result = new String[personData.length][4];
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double heightM = personData[i][1] / 100;
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;
            result[i][0] = String.valueOf(personData[i][1]);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = getStatus(bmi);
        }
        return result;
    }

    static void displayTable(String[][] data) {
        System.out.println("Person | Height(cm) | Weight(kg) | BMI   | Status");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "      | " + data[i][0] + "        | " + data[i][1] + "        | " + data[i][2] + " | " + data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Enter height of person " + (i + 1) + " (cm): ");
            personData[i][1] = scanner.nextDouble();
        }
        String[][] result = computeBMI(personData);
        displayTable(result);
        scanner.close();
    }
}
