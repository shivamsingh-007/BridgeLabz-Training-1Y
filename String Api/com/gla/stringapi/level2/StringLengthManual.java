package com.gla.stringapi.level2;

import java.util.Scanner;

public class StringLengthManual {
    static int findLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                return count;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        int manualLength = findLength(text);
        int builtInLength = text.length();
        System.out.println("Length using user-defined method = " + manualLength);
        System.out.println("Length using length() = " + builtInLength);
        scanner.close();
    }
}
