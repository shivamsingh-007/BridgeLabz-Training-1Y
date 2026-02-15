package com.gla.stringapi.level2;

import java.util.Scanner;

public class StudentScorecard {
    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = 10 + (int) (Math.random() * 90);
            scores[i][1] = 10 + (int) (Math.random() * 90);
            scores[i][2] = 10 + (int) (Math.random() * 90);
        }
        return scores;
    }

    static double[][] computeStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = (double) total / 3;
            double pct = avg;
            stats[i][0] = Math.round(total * 100.0) / 100.0;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(pct * 100.0) / 100.0;
        }
        return stats;
    }

    static String[][] computeGrades(double[][] stats) {
        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double pct = stats[i][2];
            if (pct >= 90) {
                grades[i][0] = "A+";
            } else if (pct >= 80) {
                grades[i][0] = "A";
            } else if (pct >= 70) {
                grades[i][0] = "B";
            } else if (pct >= 60) {
                grades[i][0] = "C";
            } else if (pct >= 50) {
                grades[i][0] = "D";
            } else {
                grades[i][0] = "F";
            }
        }
        return grades;
    }

    static void displayScorecard(int[][] scores, double[][] stats, String[][] grades) {
        System.out.println("Student | Physics | Chemistry | Maths | Total | Average | Percentage | Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "       | " + scores[i][0] + "      | " + scores[i][1] + "         | " + scores[i][2] + "     | " + stats[i][0] + "    | " + stats[i][1] + "       | " + stats[i][2] + "          | " + grades[i][0]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[][] scores = generateScores(n);
        double[][] stats = computeStats(scores);
        String[][] grades = computeGrades(stats);
        displayScorecard(scores, stats, grades);
        scanner.close();
    }
}
