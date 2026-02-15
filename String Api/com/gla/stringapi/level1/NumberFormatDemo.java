package com.gla.stringapi.level1;

import java.util.Scanner;

public class NumberFormatDemo {
    static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.println("Calling method to handle NumberFormatException:");
        handleException(text);
        System.out.println("Calling method to generate NumberFormatException:");
        generateException(text);
        scanner.close();
    }
}
