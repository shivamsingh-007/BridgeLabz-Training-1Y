package com.gla.stringapi.level1;

import java.util.Scanner;

public class ConvertToUpperCase {
    static String toUpperCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result = result + (char) (c - 32);
            } else {
                result = result + c;
            }
        }
        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        String manual = toUpperCaseManual(text);
        String builtIn = text.toUpperCase();
        boolean match = compareStrings(manual, builtIn);
        System.out.println("Manual uppercase = " + manual);
        System.out.println("Built-in toUpperCase() = " + builtIn);
        System.out.println("Both results match: " + match);
        scanner.close();
    }
}
