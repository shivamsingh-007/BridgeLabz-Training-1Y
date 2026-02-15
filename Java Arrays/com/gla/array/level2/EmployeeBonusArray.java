package com.gla.array.level2;

import java.util.Scanner;

public class EmployeeBonusArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("  Enter salary: ");
            salary[i] = scanner.nextDouble();
            if (salary[i] <= 0) {
                System.out.println("  Invalid salary. Please enter again.");
                i--;
                continue;
            }
            System.out.print("  Enter years of service: ");
            yearsOfService[i] = scanner.nextDouble();
            if (yearsOfService[i] < 0) {
                System.out.println("  Invalid years of service. Please enter again.");
                i--;
                continue;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 5 / 100;
            } else {
                bonus[i] = salary[i] * 2 / 100;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus = totalBonus + bonus[i];
            totalOldSalary = totalOldSalary + salary[i];
            totalNewSalary = totalNewSalary + newSalary[i];
        }
        System.out.println("Total Bonus Payout = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total New Salary = " + totalNewSalary);
        scanner.close();
    }
}
