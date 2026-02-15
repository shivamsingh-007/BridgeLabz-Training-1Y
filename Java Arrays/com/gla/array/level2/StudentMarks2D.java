package com.gla.array.level2;

import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = scanner.nextInt();
        double[][] marks = new double[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("  Physics marks: ");
            marks[i][0] = scanner.nextDouble();
            System.out.print("  Chemistry marks: ");
            marks[i][1] = scanner.nextDouble();
            System.out.print("  Maths marks: ");
            marks[i][2] = scanner.nextDouble();
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("  Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;
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
            System.out.println((i + 1) + "       | " + marks[i][0] + "     | " + marks[i][1] + "         | " + marks[i][2] + "    | " + percentage[i] + "     | " + grade[i]);
        }
        scanner.close();
    }
}
