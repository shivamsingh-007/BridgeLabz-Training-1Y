package com.gla.stringapi.level1;

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    static void generateException(String text) {
        System.out.println(text.charAt(text.length() + 5));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length() + 5));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.println("Calling method to handle StringIndexOutOfBoundsException:");
        handleException(text);
        System.out.println("Calling method to generate StringIndexOutOfBoundsException:");
        generateException(text);
        scanner.close();
    }
}
