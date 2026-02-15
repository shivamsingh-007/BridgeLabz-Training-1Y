package com.gla.stringapi.level1;

import java.util.Scanner;

public class IllegalArgumentDemo {
    static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.println("Calling method to handle IllegalArgumentException:");
        handleException(text);
        System.out.println("Calling method to generate IllegalArgumentException:");
        generateException(text);
        scanner.close();
    }
}
