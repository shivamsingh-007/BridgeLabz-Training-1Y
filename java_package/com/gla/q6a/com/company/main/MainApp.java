package com.company.main;

import com.company.hr.Employee;
import com.company.payroll.*;

public class MainApp {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Rahul Verma", "Engineering", 50000);
        Employee e2 = new Employee(2, "Sneha Patel", "Marketing", 45000);

        Payroll payroll = new Payroll();

        System.out.println("===== Employee Management System =====");
        System.out.println();

        System.out.println("--- Before Bonus ---");
        e1.displayEmployee();
        double bonus1 = payroll.calculateBonus(e1);
        System.out.println("--- After 10% Bonus ---");
        System.out.println("Bonus Added : Rs. " + bonus1);
        e1.displayEmployee();
        System.out.println();

        System.out.println("--- Before Bonus ---");
        e2.displayEmployee();
        double bonus2 = payroll.calculateBonus(e2);
        System.out.println("--- After 10% Bonus ---");
        System.out.println("Bonus Added : Rs. " + bonus2);
        e2.displayEmployee();

        System.out.println();
        System.out.println("=== Folder Structure ===");
        System.out.println("q6a/com/company/hr/Employee.java");
        System.out.println("q6a/com/company/payroll/Payroll.java");
        System.out.println("q6a/com/company/main/MainApp.java");
        System.out.println("Folder must match package name exactly so Java can locate .class files.");
    }
}
