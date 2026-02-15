package com.gla.stringapi.level1;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    static void generateException(String[] names) {
        System.out.println(names[names.length + 5]);
    }

    static void handleException(String[] names) {
        try {
            System.out.println(names[names.length + 5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many names to enter? ");
        int count = scanner.nextInt();
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }
        System.out.println("Calling method to handle ArrayIndexOutOfBoundsException:");
        handleException(names);
        System.out.println("Calling method to generate ArrayIndexOutOfBoundsException:");
        generateException(names);
        scanner.close();
    }
}
