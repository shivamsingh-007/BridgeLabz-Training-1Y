package com.gla.array.level2;

import java.util.Scanner;

public class StudentMarksGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = scanner.nextInt();
        double[] physics = new double[number];
        double[] chemistry = new double[number];
        double[] maths = new double[number];
        double[] percentage = new double[number];
        String[] grade = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("  Physics marks: ");
            physics[i] = scanner.nextDouble();
            System.out.print("  Chemistry marks: ");
            chemistry[i] = scanner.nextDouble();
            System.out.print("  Maths marks: ");
            maths[i] = scanner.nextDouble();
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("  Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3;
            if (percentage[i] >= 90) {
                grade[i] = "A+";
            } else if (percentage[i] >= 80) {
                grade[i] = "A";
            } else if (percentage[i] >= 70) {
                grade[i] = "B";
            } else if (percentage[i] >= 60) {
                grade[i] = "C";
            } else if (percentage[i] >= 50) {
                grade[i] = "D";
            } else {
                grade[i] = "F";
            }
        }
        System.out.println("Student | Physics | Chemistry | Maths | Percentage | Grade");
        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + "       | " + physics[i] + "     | " + chemistry[i] + "         | " + maths[i] + "    | " + percentage[i] + "     | " + grade[i]);
        }
        scanner.close();
    }
}
