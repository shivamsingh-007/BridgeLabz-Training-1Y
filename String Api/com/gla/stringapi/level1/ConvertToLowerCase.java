package com.gla.stringapi.level1;

import java.util.Scanner;

public class ConvertToLowerCase {
    static String toLowerCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result = result + (char) (c + 32);
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
        String manual = toLowerCaseManual(text);
        String builtIn = text.toLowerCase();
        boolean match = compareStrings(manual, builtIn);
        System.out.println("Manual lowercase = " + manual);
        System.out.println("Built-in toLowerCase() = " + builtIn);
        System.out.println("Both results match: " + match);
        scanner.close();
    }
}
